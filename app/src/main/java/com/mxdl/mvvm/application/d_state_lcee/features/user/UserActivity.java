package com.mxdl.mvvm.application.d_state_lcee.features.user;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.mxdl.mvvm.R;
import com.mxdl.mvvm.application.d_state_lcee.common.bean.Lcee;
import com.mxdl.mvvm.application.d_state_lcee.common.bean.User;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.UserRepository;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.db.DBHelper;

/**
 * Created by mxdl on 2017/10/4.
 */

public class UserActivity extends AppCompatActivity {
    private static final String TAG = UserActivity.class.getName();
    // vm
    private UserViewModel userViewModel;

    // view
    private View vContent;
    private View vError;
    private View vLoading;
    private View vEmpty;

    private TextView tvId;
    private TextView tvName;
    private EditText etUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_activity_user);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        vContent = findViewById(R.id.v_content);
        vError = findViewById(R.id.v_error);
        vLoading = findViewById(R.id.v_loading);
        vEmpty = findViewById(R.id.v_empty);

        tvId = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
        etUsername = (EditText) findViewById(R.id.et_username);
    }

    private void initData() {
        DBHelper.getInstance().init(this);
        UserRepository.getInstance().init(this);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<Lcee<User>>() {
            @Override
            public void onChanged(@Nullable Lcee<User> data) {
                updateView(data);
            }
        });

        reload();
    }

    private void initEvent() {
        View.OnClickListener reloadClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                reload();
            }
        };
        vError.setOnClickListener(reloadClickListener);
        vEmpty.setOnClickListener(reloadClickListener);

        findViewById(R.id.btn_search).setOnClickListener(reloadClickListener);

        etUsername.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    hideKeyboard();
                    reload();
                    return true;
                }
                return false;
            }
        });
    }

    private void hideKeyboard() {
        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(UserActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void reload() {
        // reload
        userViewModel.reload(getUsername());
    }

    private void updateView(Lcee<User> lcee) {
        switch (lcee.status) {
            case Content: {
                showContent();
                tvId.setText(lcee.data.getId() + "");
                tvName.setText(lcee.data.getName());
                break;
            }
            case Empty: {
                showEmpty();
                break;
            }
            case Error: {
                showError();
                break;
            }
            case Loading: {
                showLoading();
                break;
            }
        }
    }

    private void showContent() {
        vContent.setVisibility(View.VISIBLE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.GONE);
    }

    private void showEmpty() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.VISIBLE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.GONE);
    }

    private void showError() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.VISIBLE);
        vLoading.setVisibility(View.GONE);
    }

    private void showLoading() {
        vContent.setVisibility(View.GONE);
        vEmpty.setVisibility(View.GONE);
        vError.setVisibility(View.GONE);
        vLoading.setVisibility(View.VISIBLE);
    }

    private String getUsername() {
        return etUsername.getText().toString();
    }
}

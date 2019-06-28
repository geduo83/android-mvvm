package com.mxdl.mvvm.application.c_cache.features.user;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.mxdl.mvvm.R;
import com.mxdl.mvvm.application.c_cache.common.bean.User;
import com.mxdl.mvvm.application.c_cache.common.repository.UserRepository;
import com.mxdl.mvvm.application.c_cache.common.repository.local.db.DBHelper;

/**
 * Created by mxdl on 2017/10/4.
 */

public class UserActivity extends AppCompatActivity {
    private static final String TAG = UserActivity.class.getName();
    private UserViewModel userViewModel;
    private TextView tvId;
    private TextView tvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity_user);
        initView();
        initData();
    }

    private void initView() {
        tvId = (TextView) findViewById(R.id.tv_id);
        tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        DBHelper.getInstance().init(this);
        UserRepository.getInstance().init(this);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUser("ittianyu").observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                updateView(user);
            }
        });
    }

    private void updateView(User user) {
        Log.d(TAG, user.toString());
        tvId.setText(user.getId() + "");
        tvName.setText(user.getName());
    }

}

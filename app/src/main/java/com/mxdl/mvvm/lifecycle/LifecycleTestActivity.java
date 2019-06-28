package com.mxdl.mvvm.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mxdl.mvvm.R;
import com.mxdl.mvvm.lifecycle.presenter.LifecyclePresenter;

/**
 * Description: <LifecycleTestActivity><br>
 * Author:      mxdl<br>
 * Date:        2019/6/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LifecycleTestActivity extends AppCompatActivity {
    public static final String TAG = LifecycleTestActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MYTAG","onCreate start");
        setContentView(R.layout.activity_lifecycle_test);
        getLifecycle().addObserver(new LifecyclePresenter());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MYTAG","onDestory start");
    }
}

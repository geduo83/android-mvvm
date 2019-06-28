package com.mxdl.mvvm.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mxdl.mvvm.R;

/**
 * Description: <LoginActivity><br>
 * Author:      mxdl<br>
 * Date:        2019/6/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LoginActivity extends AppCompatActivity {
    private MutableLiveData<String> mCurrentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
    }
}

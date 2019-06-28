package com.mxdl.mvvm.livedata.viewmodle;

import android.arch.lifecycle.ViewModel;

import com.mxdl.mvvm.livedata.model.LoginModel;

/**
 * Description: <LoginViewModel><br>
 * Author:      mxdl<br>
 * Date:        2019/6/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LoginViewModel extends ViewModel {

    private LoginModel mLoginModel;

    public LoginViewModel() {
        mLoginModel = new LoginModel();
    }

}

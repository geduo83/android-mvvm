package com.mxdl.mvvm.application.i_dagger2.common.repository.local.service;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.i_dagger2.common.bean.User;


/**
 * Created by mxdl on 2017/10/7.
 */

public interface UserService {
    LiveData<Long> add(User user);

    LiveData<User> queryByUsername(String username);
}

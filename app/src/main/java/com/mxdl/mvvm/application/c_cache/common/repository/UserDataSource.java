package com.mxdl.mvvm.application.c_cache.common.repository;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.c_cache.common.bean.User;

/**
 * Created by mxdl on 2017/10/6.
 */

public interface UserDataSource {
    LiveData<User> queryUserByUsername(String username);
}

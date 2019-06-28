package com.mxdl.mvvm.application.g_data_binding.common.repository;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.g_data_binding.common.bean.Lcee;
import com.mxdl.mvvm.application.g_data_binding.common.bean.User;

/**
 * Created by mxdl on 2017/10/6.
 */

public interface UserDataSource {
    LiveData<Lcee<User>> queryUserByUsername(String username);
}

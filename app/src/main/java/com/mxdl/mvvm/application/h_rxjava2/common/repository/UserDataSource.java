package com.mxdl.mvvm.application.h_rxjava2.common.repository;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.h_rxjava2.common.bean.Lcee;
import com.mxdl.mvvm.application.h_rxjava2.common.bean.User;

/**
 * Created by mxdl on 2017/10/6.
 */

public interface UserDataSource {
    LiveData<Lcee<User>> queryUserByUsername(String username);
}

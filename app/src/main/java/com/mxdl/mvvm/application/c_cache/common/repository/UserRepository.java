package com.mxdl.mvvm.application.c_cache.common.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.mxdl.mvvm.application.c_cache.common.bean.User;
import com.mxdl.mvvm.application.c_cache.common.repository.local.LocalUserDataSource;
import com.mxdl.mvvm.application.c_cache.common.repository.remote.RemoteUserDataSource;
import com.mxdl.mvvm.application.c_cache.common.utils.NetworkUtils;

/**
 * Created by mxdl on 2017/10/6.
 */

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private UserRepository() {
    }
    public static UserRepository getInstance() {
        return instance;
    }


    private Context context;
    private UserDataSource remoteUserDataSource = RemoteUserDataSource.getInstance();
    private UserDataSource localUserDataSource = LocalUserDataSource.getInstance();

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    public LiveData<User> getUser(String username) {
        if (NetworkUtils.isConnected(context)) {
            return remoteUserDataSource.queryUserByUsername(username);
        } else {
            return localUserDataSource.queryUserByUsername(username);
        }
    }

}

package com.mxdl.mvvm.application.i_dagger2.common.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.mxdl.mvvm.application.i_dagger2.common.bean.Lcee;
import com.mxdl.mvvm.application.i_dagger2.common.bean.User;
import com.mxdl.mvvm.application.i_dagger2.common.dagger.qualifier.Local;
import com.mxdl.mvvm.application.i_dagger2.common.dagger.qualifier.Remote;
import com.mxdl.mvvm.application.i_dagger2.common.utils.NetworkUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mxdl on 2017/10/6.
 */
@Singleton
public class UserRepository {
    private Context context;
    private UserDataSource remoteUserDataSource;
    private UserDataSource localUserDataSource;

    @Inject
    public UserRepository(Context context, @Remote UserDataSource remoteUserDataSource,
                          @Local UserDataSource localUserDataSource) {
        this.context = context;
        this.remoteUserDataSource = remoteUserDataSource;
        this.localUserDataSource = localUserDataSource;
    }

    public LiveData<Lcee<User>> getUser(String username) {
        if (NetworkUtils.isConnected(context)) {
            return remoteUserDataSource.queryUserByUsername(username);
        } else {
            return localUserDataSource.queryUserByUsername(username);
        }
    }

}

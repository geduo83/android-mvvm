package com.mxdl.mvvm.application.d_state_lcee.common.repository.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.mxdl.mvvm.application.d_state_lcee.common.bean.Lcee;
import com.mxdl.mvvm.application.d_state_lcee.common.bean.User;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.UserDataSource;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.LocalUserDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mxdl on 2017/10/6.
 */

public class RemoteUserDataSource implements UserDataSource {
    private static final RemoteUserDataSource instance = new RemoteUserDataSource();
    private RemoteUserDataSource() {
    }
    public static RemoteUserDataSource getInstance() {
        return instance;
    }


    private UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);

    @Override
    public LiveData<Lcee<User>> queryUserByUsername(String username) {
        final MutableLiveData<Lcee<User>> data = new MutableLiveData<>();
        data.setValue(Lcee.<User>loading());

        userApi.queryUserByUsername(username)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        if (null == user) {
                            data.setValue(Lcee.<User>empty());
                            return;
                        }
                        data.setValue(Lcee.content(user));
                        // update cache
                        LocalUserDataSource.getInstance().addUser(user);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                        data.setValue(Lcee.<User>error(t));
                    }
                });
        return data;
    }
}

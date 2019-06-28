package com.mxdl.mvvm.application.d_state_lcee.common.repository.local;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.mxdl.mvvm.application.d_state_lcee.common.bean.Lcee;
import com.mxdl.mvvm.application.d_state_lcee.common.bean.User;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.UserDataSource;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.service.UserService;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.service.UserServiceImpl;

/**
 * Created by mxdl on 2017/10/6.
 */

public class LocalUserDataSource implements UserDataSource {
    private static final LocalUserDataSource instance = new LocalUserDataSource();

    private LocalUserDataSource() {
    }

    public static LocalUserDataSource getInstance() {
        return instance;
    }


    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public LiveData<Lcee<User>> queryUserByUsername(String username) {
        final MediatorLiveData<Lcee<User>> data = new MediatorLiveData<>();
        data.setValue(Lcee.<User>loading());

        data.addSource(userService.queryByUsername(username), new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (null == user) {
                    data.setValue(Lcee.<User>empty());
                } else {
                    data.setValue(Lcee.content(user));
                }
            }
        });
        return data;
    }
    
    public LiveData<Long> addUser(User user) {
        return userService.add(user);
    }
}

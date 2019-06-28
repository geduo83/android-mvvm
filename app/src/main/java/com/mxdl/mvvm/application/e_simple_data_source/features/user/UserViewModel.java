package com.mxdl.mvvm.application.e_simple_data_source.features.user;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.mxdl.mvvm.application.e_simple_data_source.common.bean.Lcee;
import com.mxdl.mvvm.application.e_simple_data_source.common.bean.User;
import com.mxdl.mvvm.application.e_simple_data_source.common.repository.remote.UserRepository;

/**
 * Created by mxdl on 2017/10/4.
 */

public class UserViewModel extends ViewModel {
    private UserRepository userRepository = UserRepository.getInstance();
    private MutableLiveData<String> ldUsername;;
    private LiveData<Lcee<User>> ldUser;

    public LiveData<Lcee<User>> getUser() {
        if (null == ldUser) {
            ldUsername = new MutableLiveData<>();
            ldUser = Transformations.switchMap(ldUsername, new Function<String, LiveData<Lcee<User>>>() {
                @Override
                public LiveData<Lcee<User>> apply(String username) {
                    return userRepository.getUser(username);
                }
            });
        }
        return ldUser;
    }

    public void reload(String username) {
        ldUsername.setValue(username);
    }
}

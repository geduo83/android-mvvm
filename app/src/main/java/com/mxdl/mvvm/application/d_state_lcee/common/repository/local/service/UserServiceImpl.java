package com.mxdl.mvvm.application.d_state_lcee.common.repository.local.service;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.mxdl.mvvm.application.d_state_lcee.common.bean.User;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.dao.UserDao;
import com.mxdl.mvvm.application.d_state_lcee.common.repository.local.db.DBHelper;

/**
 * Created by mxdl on 2017/10/7.
 */

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    private UserDao userDao = DBHelper.getInstance().getDb().getUserDao();

    @Override
    public LiveData<Long> add(final User user) {
        // transfer long to LiveData<Long>
        final MutableLiveData<Long> data = new MutableLiveData<>();
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                return userDao.add(user);
            }

            @Override
            protected void onPostExecute(Long rowId) {
                data.setValue(rowId);
            }
        }.execute();
        return data;
    }

    @Override
    public LiveData<User> queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

}

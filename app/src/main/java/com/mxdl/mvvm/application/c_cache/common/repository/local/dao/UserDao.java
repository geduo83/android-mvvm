package com.mxdl.mvvm.application.c_cache.common.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mxdl.mvvm.application.c_cache.common.bean.User;


/**
 * Created by mxdl on 2017/10/7.
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)// cache need update
    Long add(User user);

    @Query("select * from user where login = :username")
    LiveData<User> queryByUsername(String username);
}

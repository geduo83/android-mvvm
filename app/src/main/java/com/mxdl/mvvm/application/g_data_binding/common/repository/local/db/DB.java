package com.mxdl.mvvm.application.g_data_binding.common.repository.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mxdl.mvvm.application.g_data_binding.common.bean.User;
import com.mxdl.mvvm.application.g_data_binding.common.repository.local.dao.UserDao;

/**
 * Created by mxdl on 2017/10/7.
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {
    public abstract UserDao getUserDao();

}

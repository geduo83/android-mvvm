package com.mxdl.mvvm.application.f_load_more.common.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mxdl.mvvm.application.f_load_more.common.bean.project.Projects;


/**
 * Created by mxdl on 2017/10/7.
 */
@Dao
public interface ProjectsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)// cache need update
    Long add(Projects projects);

    @Query("select * from projects where page=:page")
    LiveData<Projects> queryProjects(int page);
}

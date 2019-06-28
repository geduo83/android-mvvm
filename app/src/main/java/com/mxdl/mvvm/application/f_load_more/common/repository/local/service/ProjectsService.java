package com.mxdl.mvvm.application.f_load_more.common.repository.local.service;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.f_load_more.common.bean.project.Projects;


/**
 * Created by mxdl on 2017/10/7.
 */

public interface ProjectsService {
    LiveData<Long> add(Projects projects);

    /**
     *
     * @param page start from 1
     * @return
     */
    LiveData<Projects> queryProjects(int page);
}

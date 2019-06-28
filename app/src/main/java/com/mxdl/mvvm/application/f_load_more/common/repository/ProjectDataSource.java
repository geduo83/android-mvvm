package com.mxdl.mvvm.application.f_load_more.common.repository;

import android.arch.lifecycle.LiveData;

import com.mxdl.mvvm.application.f_load_more.common.bean.Lcee;
import com.mxdl.mvvm.application.f_load_more.common.bean.project.Projects;

/**
 * Created by mxdl on 2017/10/6.
 */

public interface ProjectDataSource {
    LiveData<Lcee<Projects>> queryProjects(int page);
}

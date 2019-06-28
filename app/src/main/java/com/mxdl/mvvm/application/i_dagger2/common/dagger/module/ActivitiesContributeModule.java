package com.mxdl.mvvm.application.i_dagger2.common.dagger.module;

import com.mxdl.mvvm.application.i_dagger2.features.user.UserActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mxdl on 2017/11/5.
 */
@Module
public abstract class ActivitiesContributeModule {
    @ContributesAndroidInjector(modules = {UserActivityModule.class})
    abstract UserActivity userActivityInjector();

}

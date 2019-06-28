package com.mxdl.mvvm.application.i_dagger2.common.dagger.component;

import com.mxdl.mvvm.BaseApplication;
import com.mxdl.mvvm.application.i_dagger2.common.dagger.module.ActivitiesContributeModule_UserActivityInjector;
import com.mxdl.mvvm.application.i_dagger2.common.dagger.module.BaseModule;
import com.mxdl.mvvm.application.i_dagger2.common.dagger.module.UserViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mxdl on 2017/10/30.
 */
@Singleton
@Component(modules = {
        UserViewModelModule.class,
        BaseModule.class,
        ActivitiesContributeModule_UserActivityInjector.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
})
public interface BaseApplicationComponent {
    void inject(BaseApplication application);

}

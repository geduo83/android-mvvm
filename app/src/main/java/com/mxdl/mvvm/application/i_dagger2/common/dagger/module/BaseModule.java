package com.mxdl.mvvm.application.i_dagger2.common.dagger.module;

import android.content.Context;

import com.mxdl.mvvm.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mxdl on 2017/11/6.
 */
@Module
public class BaseModule {

    @Provides
    Context provideContext() {
        return BaseApplication.getAppContext();
    }
}

package com.mxdl.mvvm.lifecycle.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Description: <LifecyclePresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/6/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LifecyclePresenter implements LifecycleObserver {
    public static final String TAG = LifecyclePresenter.class.getSimpleName();
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(LifecycleOwner owner) {
        Log.v("MYTAG","onCreate start...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        Log.v("MYTAG","onDestroy start...");
    }

}

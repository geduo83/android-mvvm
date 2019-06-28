package com.mxdl.mvvm.application.h_rxjava2.common.repository.remote;


import com.mxdl.mvvm.application.h_rxjava2.common.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by mxdl on 2017/10/6.
 */

public interface UserApi {
    @GET("/users/{username}")
    Observable<User> queryUserByUsername(@Path("username") String username);
}

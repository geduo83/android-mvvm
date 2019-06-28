package com.mxdl.mvvm.application.c_cache.common.repository.remote;


import com.mxdl.mvvm.application.c_cache.common.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by mxdl on 2017/10/6.
 */

public interface UserApi {
    @GET("/users/{username}")
    Call<User> queryUserByUsername(@Path("username") String username);
}

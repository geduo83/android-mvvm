package com.mxdl.mvvm.application.e_simple_data_source.common.repository.local.service;

import com.mxdl.mvvm.application.e_simple_data_source.common.bean.User;


/**
 * Created by mxdl on 2017/10/7.
 */

public interface UserService {
    Long add(User user);

    User queryByUsername(String username) throws Exception;
}

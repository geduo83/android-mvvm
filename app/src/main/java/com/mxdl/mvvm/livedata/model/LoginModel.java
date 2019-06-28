package com.mxdl.mvvm.livedata.model;

/**
 * Description: <LoginModel><br>
 * Author:      mxdl<br>
 * Date:        2019/6/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LoginModel {
    public boolean login(String name,String pwd){
        if("mxdl".equals(name) && "123456".equals(pwd)){
            return true;
        }else{
            return false;
        }
    }
}

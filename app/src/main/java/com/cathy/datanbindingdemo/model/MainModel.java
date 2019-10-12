package com.cathy.datanbindingdemo.model;

import com.cathy.datanbindingdemo.bean.UserBean;

/**
 * 数据操作类：
 *
 * I/o流操作
 *
 */
public class MainModel {

    public UserBean getLoginData(){
        //可以进行网络请求或者I/o操作
        UserBean userBean = new UserBean();
        userBean.setAge(38);
        userBean.setName("Hello MVVM");
        return userBean;
    }
}

package com.cathy.datanbindingdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.cathy.datanbindingdemo.bean.UserBean;
import com.cathy.datanbindingdemo.model.MainModel;

public class MainViewModel extends AndroidViewModel {
    private MainModel mainModel;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mainModel = new MainModel();
    }

    public UserBean getLoginData(){
        return mainModel.getLoginData();
    }
}

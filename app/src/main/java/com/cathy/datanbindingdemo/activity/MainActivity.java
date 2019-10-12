package com.cathy.datanbindingdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cathy.datanbindingdemo.R;
import com.cathy.datanbindingdemo.bean.UserBean;
import com.cathy.datanbindingdemo.databinding.ActivityMainBinding;
import com.cathy.datanbindingdemo.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding dataBinding;
    private UserBean userBean;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //step 1:bind the layout
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //step 2:init user data
       userBean =new UserBean();
        userBean.setName("Catherine");
        userBean.setAge(25);
        //step 3:binding data
        dataBinding.setUserBean(userBean);

        initView();
        initRecycleView();
        mainViewModel = new MainViewModel(this.getApplication());

    }


    /**
     * 初始化数据
     */
   private int age=26;
    private void initView() {

        dataBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean.setName("Alice");
                userBean.setAge(age);
                age += 1;
//            dataBinding.setUserBean(userBean);

                //second method :MVVM
//           userBean= mainViewModel.getLoginData();
//           dataBinding.setUserBean(userBean);
//
                //third method
                Message message = new Message();
                message.obj = userBean;
                message.what = 1;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * init recycle view
     */
    private void initRecycleView(){

    }

    public void refreshData(UserBean userBean){
        if (userBean != null){
            dataBinding.setUserBean(userBean);
        }
    }

    private Handler handler  = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg != null){
                if (msg.obj instanceof UserBean) {
                    UserBean userBean = (UserBean) msg.obj;
                    dataBinding.setUserBean(userBean);
                }

            }
        }
    };


    /**
     * 解决Handler内存泄漏的两点：
     * 1：在界面销毁的时候将message进行移除。
     * 2：将内部类改爲匿名静态内部类。
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}

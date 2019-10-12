package com.cathy.datanbindingdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.cathy.datanbindingdemo.R;
import com.cathy.datanbindingdemo.bean.UserBean;
import com.cathy.datanbindingdemo.databinding.FragmentLoginBinding;
import com.cathy.datanbindingdemo.databinding.FragmentStartBinding;

public class LoginFragment extends Fragment {
    private String url="http://n.sinaimg.cn/sinacn10110/126/w430h496/20190906/611a-ieftthx6435831.jpg";

    FragmentLoginBinding fragmentLoginBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        return fragmentLoginBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }


    private void initView(){
        fragmentLoginBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Glide.with(fragmentLoginBinding.ivGlide)
                     .load(url)
                     .error(R.mipmap.ic_launcher)
                     .placeholder(R.drawable.ic_launcher_background)
                     .into(fragmentLoginBinding.ivGlide);

            }
        });
        fragmentLoginBinding.ivGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBean userBean =new UserBean();
                userBean.setName("pigpig");
                userBean.setAge(1);
                Bundle bundle= new Bundle();
                bundle.putSerializable("userBean",userBean);
                Navigation.findNavController(v).navigate(R.id.frg_start,bundle);
            }
        });
    }
}

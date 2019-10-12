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

import com.cathy.datanbindingdemo.R;
import com.cathy.datanbindingdemo.activity.MainActivity;
import com.cathy.datanbindingdemo.bean.UserBean;
import com.cathy.datanbindingdemo.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {



    FragmentStartBinding fragmentStartBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentStartBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false);
        return fragmentStartBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null){
       UserBean userBean=(UserBean) getArguments().get("userBean");
       if(userBean!=null){
           ((MainActivity)getActivity()).refreshData(userBean);
       }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView(){
        fragmentStartBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jump into another interface
                Navigation.findNavController(view).navigate(R.id.frg_login);
            }
        });
    }
}

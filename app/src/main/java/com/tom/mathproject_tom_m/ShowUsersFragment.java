package com.tom.mathproject_tom_m;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ShowUsersFragment extends Fragment {

Vm MainViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_show_users, container, false);
        MainViewmodel= new ViewModelProvider(requireActivity()).get(Vm.class);
       initView(view);
       return view;
    }

    private void initView(View view) {

    }
}
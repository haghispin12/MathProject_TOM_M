package com.tom.mathproject_tom_m;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ShowUsersFragment extends Fragment {

Vm MainViewmodel;
TextView user1;
    TextView rate23;

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
     user1=view.findViewById(R.id.user1);
        user1.setText(MainViewmodel.getUsername());
      rate23=view.findViewById(R.id.rate23);
       rate23.setText(MainViewmodel.getUserRate()+"");
    }
}
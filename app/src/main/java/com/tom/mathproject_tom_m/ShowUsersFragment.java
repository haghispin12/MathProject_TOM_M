package com.tom.mathproject_tom_m;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import kotlin.Result;


public class ShowUsersFragment extends Fragment {

Vm MainViewmodel;
TextView user1;
    TextView score12345;
    TextView rate23;
    Button picture;
    Button adduser;
    Uri uri;
    ImageView pic1;

    ActivityResultLauncher<Intent> startCamera = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),

            new ActivityResultCallback<ActivityResult>() {

                @Override

                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == RESULT_OK) {
                        MainViewmodel.user.setUri(uri);
                      pic1.setImageURI(uri);

                    }

                }

            });

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_show_users, container, false);
        MainViewmodel= new ViewModelProvider(requireActivity()).get(Vm.class);

       initView(view);
       if (getActivity()!=null){
           MainViewmodel.Myusers.observe(getActivity(), new Observer<ArrayList<User>>() {
               @Override
               public void onChanged(ArrayList<User> users) {
int n=0;
               }
           });
           MainViewmodel.getMyusers(getActivity());
       }
       return view;
    }

    private void initView(View view) {
        adduser=view.findViewById(R.id.adduser);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity()!=null){
                    long id=MainViewmodel.dbAdduser(getActivity());
                    Toast.makeText(getActivity(),"insert row id"+id,Toast.LENGTH_LONG).show();
                }
            }
        });
        score12345=view.findViewById(R.id.score12345);
        score12345.setText(MainViewmodel.getUserScore());
     user1=view.findViewById(R.id.user1);
        user1.setText(MainViewmodel.getUsername());
      rate23=view.findViewById(R.id.rate23);
       rate23.setText(MainViewmodel.getUserRate()+"");
        pic1=view.findViewById(R.id.pic1);
        picture=view.findViewById(R.id.picture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();

                values.put(MediaStore.Images.Media.TITLE, "New Picture");

                values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera");

                uri =
                        requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                startCamera.launch(cameraIntent);
            }
        });
    }

}
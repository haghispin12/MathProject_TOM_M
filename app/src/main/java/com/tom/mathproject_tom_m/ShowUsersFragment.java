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
import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import kotlin.Result;


public class ShowUsersFragment extends Fragment implements MenuProvider {

Vm MainViewmodel;
TextView user1;
    TextView score12345;
    TextView rate23;
    Button picture;
    Button adduser;
    Uri uri;
    ImageView pic1;
    RecyclerView recyclerView;


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
    private MenuItem itemDelete;
    private MenuItem itemEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_show_users, container, false);
        MainViewmodel= new ViewModelProvider(requireActivity()).get(Vm.class);
        recyclerView=view.findViewById(R.id.rcShowUsers1);
       initView(view);

       if (getActivity()!=null){
           MainViewmodel.Myusers.observe(getActivity(), new Observer<ArrayList<User>>() {
               @Override
               public void onChanged(ArrayList<User> users) {
             adapteruser ad123=new adapteruser(users, new adapteruser.OnItemClickListener1() {
    @Override
    public void onItemClick(User item) {
        int n=0;
        itemDelete.setVisible(true);
        itemEdit.setVisible(true);
        MainViewmodel.user=item;
        score12345.setText(MainViewmodel.user.getScore()+"");
        rate23.setText(MainViewmodel.user.getRate()+"");
        user1.setText(MainViewmodel.user.getName());

    }
});
recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
recyclerView.setAdapter(ad123);
recyclerView.setHasFixedSize(true);
               }

           });
           MainViewmodel.getMyusers(getActivity());

       }
        requireActivity().addMenuProvider(this);
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

    @Override
    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menuxml,menu);
        itemDelete = menu.findItem(R.id.delete);
        itemDelete.setVisible(false);
       itemEdit = menu.findItem(R.id.edit);
        itemEdit.setVisible(false);
       // super.onCreateOptionsMenu(menu,menuInflater);
    }

    @Override
    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {

            case R.id.delete:
                return true;
        }
        return false;
    }
}
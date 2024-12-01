package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ShowallUsersActivity extends AppCompatActivity {

    public void  Showlist(){
        ArrayList<Fruit> fruits=new ArrayList<>();
        fruits.add(new Fruit("banana",R.drawable.img_1));
        fruits.add(new Fruit("apple",R.drawable.img_5));
        fruits.add(new Fruit("orange",R.drawable.img));
        fruits.add(new Fruit("grapes",R.drawable.img_2));
        fruits.add(new Fruit("lemon",R.drawable.img_3));
        fruits.add(new Fruit("fruits",R.drawable.img_4);
     AdapterFruit adapterFruit=new AdapterFruit(fruits,new adapterFruit.OnItemClickListener()){
        public void onItemClick(User item) {
Toast.makeText(ShowFruitsActivity.this,item.getName(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall_users);

    }
}
package com.tom.mathproject_tom_m;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowallUsersActivity<rcShowUsers> extends AppCompatActivity {
    ;
    private RecyclerView rcShowUsers;

    public void Showlist() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("banana", R.drawable.img_1));
        fruits.add(new Fruit("apple", R.drawable.img_5));
        fruits.add(new Fruit("orange", R.drawable.img));
        fruits.add(new Fruit("grapes", R.drawable.img_2));
        fruits.add(new Fruit("lemon", R.drawable.img_3));
        fruits.add(new Fruit("fruits", R.drawable.img_4));
        AdapterFruit adapterFruit = new AdapterFruit(fruits, new AdapterFruit.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit item) {
                Toast.makeText(ShowallUsersActivity.this, item.getfruitName(), Toast.LENGTH_LONG).show();
            }
        }) {


        };
        rcShowUsers.setLayoutManager(new LinearLayoutManager(this));
        rcShowUsers.setAdapter(adapterFruit);
        rcShowUsers.setHasFixedSize(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall_users);
        rcShowUsers = findViewById(R.id.rcShowUsers);
        Showlist();
    }
}
package com.junipersys.fragmentspractice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment = new ListFragment();
        FragmentManager fragman = getSupportFragmentManager();

        FragmentTransaction fragtrans = fragman.beginTransaction();
        fragtrans.add(R.id.placeholder, listFragment);
        fragtrans.commit();
    }
}

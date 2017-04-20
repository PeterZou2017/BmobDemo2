package com.example.bmobdemo2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bmobdemo2.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   Bmob.initialize(this,"1fdbebaf8a3b65ce6623ce7a52f29a5e");


    }
}

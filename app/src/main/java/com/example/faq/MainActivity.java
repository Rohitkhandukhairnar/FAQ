package com.example.faq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<version> versionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView=findViewById(R.id.recycleview);
        initData();
        setRecyleView();
    }

    private void setRecyleView() {
        versionadapter versionadapter = new versionadapter(versionList);
        recyclerView.setAdapter(versionadapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        versionList=new ArrayList<>();
        versionList.add(new version( "Android 10","version 10","Api level 29","Description"));
    }
}
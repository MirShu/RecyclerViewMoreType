package com.example.recyclerviewmoretype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerBjbView;
    VoteInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerBjbView = findViewById(R.id.recyclerBJBView);
        bindData();
    }

    GridLayoutManager gridLayoutManager;
    private List<String> list;
    private void bindData() {

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false);
        recyclerBjbView.setLayoutManager(gridLayoutManager);
        adapter = new VoteInfoAdapter(list);
        recyclerBjbView.setAdapter(adapter);

        setHeader(recyclerBjbView);
        setMiddle(recyclerBjbView);
    }



    //添加头部
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_bjb_head, view, false);
        adapter.setHeaderView(header);

    }


    //在RecycleView 中间添加布局
    private void setMiddle(RecyclerView view) {
        View middle = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_bjb_middle, view, false);
        adapter.setMiddleView(middle);
    }


}
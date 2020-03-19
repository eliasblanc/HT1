package com.example.spacer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String VALUE_KEY = "Value";
    RecyclerView dataList;
    List<String> nums;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList=findViewById(R.id.dataList);
        nums=new ArrayList<>();

        if (savedInstanceState != null) {
            n = savedInstanceState.getInt(VALUE_KEY);
        } else {
            n = 10;
        }

        for (int i=1;i<=n;i++) nums.add(i+"");

        final Adapter adapter = new Adapter(this,nums);

        int orientation = getResources().getConfiguration().orientation;
        int a;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            a=4;
        } else {
            a=3;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,a);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums.add(nums.size()+1+" ");
                adapter.notifyDataSetChanged();
            }
        });
        
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        n=nums.size();
        outState.putInt(VALUE_KEY, n);
    }
}

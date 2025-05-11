package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaceAdapter adapter;
    private List<Place> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 지도 버튼
        Button btnOpenMap = findViewById(R.id.btnOpenMap);
        btnOpenMap.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intent);
        });

        // 아이콘 버튼들
        ImageButton btnPlan = findViewById(R.id.btnPlan);
        ImageButton btnCommunity = findViewById(R.id.btnCommunity);
        ImageButton btnRoulette = findViewById(R.id.btnRoulette);
        ImageButton btnGroup = findViewById(R.id.btnGroup);

        btnPlan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlanActivity.class);
            startActivity(intent);
        });

        btnCommunity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CommunityActivity.class);
            startActivity(intent);
        });

        btnRoulette.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RouletteActivity.class);
            startActivity(intent);
        });

        btnGroup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GroupActivity.class);
            startActivity(intent);
        });

        // RecyclerView 셋업
        recyclerView = findViewById(R.id.recyclerPlace);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        placeList = new ArrayList<>();
        placeList.add(new Place(R.drawable.sample1, "제주도"));
        placeList.add(new Place(R.drawable.sample2, "부산"));
        placeList.add(new Place(R.drawable.sample3, "강릉"));

        adapter = new PlaceAdapter(this, placeList);
        recyclerView.setAdapter(adapter);
    }
}

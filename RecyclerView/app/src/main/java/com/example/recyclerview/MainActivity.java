package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewData = getDataForRecyclerView();
        recyclerViewLandScape = findViewById(R.id.recyclerLand);
        RecyclerView.LayoutManager layouLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layouLinear);
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewData);
        recyclerViewLandScape.setAdapter((landScapeAdapter));
    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("anhmeocute1.jpg", "ảnh meo cute 1");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("anhmeocute2", "ảnh mèo con cute 2"));
        dsDuLieu.add(new LandScape("anhmeocute3", "ảnh mèo con cute 3"));
        return dsDuLieu;
    }
}
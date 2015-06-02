package com.gamatechno.exampleglidevspicasso;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gamatechno.exampleglidevspicasso.adapter.ImageAdapter;
import com.gamatechno.exampleglidevspicasso.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PicassoActivity extends ActionBarActivity {
    @InjectView(R.id.recylerView)
    RecyclerView recyclerView;

    private ImageAdapter adapter;

    private List<ImageModel> imageModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.inject(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        imageModelList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            imageModelList.add(new ImageModel("image " + i, "http://lorempixel.com/500/500/sports/"+i));
        }

        adapter = new ImageAdapter(this, imageModelList, MainActivity.PICASSO);
        recyclerView.setAdapter(adapter);
    }
}

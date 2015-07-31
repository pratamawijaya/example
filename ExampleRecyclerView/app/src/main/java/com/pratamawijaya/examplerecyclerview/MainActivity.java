package com.pratamawijaya.examplerecyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pratamawijaya.examplerecyclerview.adapter.MainAdapter;
import com.pratamawijaya.examplerecyclerview.helper.DividedItemDecoration;
import com.pratamawijaya.examplerecyclerview.helper.RecyclerItemClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private String[] listMenu = {
            "Default",
            "Custom Adapter"
    };

    private MainAdapter stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        stringArrayAdapter = new MainAdapter(this, listMenu);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(stringArrayAdapter);
        recyclerView.addItemDecoration(new DividedItemDecoration(this, DividedItemDecoration.VERTICAL_LIST));

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, "Toast " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

}

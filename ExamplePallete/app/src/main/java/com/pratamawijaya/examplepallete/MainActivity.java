package com.pratamawijaya.examplepallete;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.pratamawijaya.examplepallete.adapter.CoverAdapter;
import com.pratamawijaya.examplepallete.model.CoverItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.recyclerview)
    RecyclerView recyclerView;

    private CoverAdapter adapter;
    private List<CoverItem> coverItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        coverItems = new ArrayList<>();
        coverItems.add(new CoverItem("Raisa", R.drawable.coveralbum_raisa));
        coverItems.add(new CoverItem("Tulus", R.drawable.coveralbum_tulus));
        coverItems.add(new CoverItem("D'Masive", R.drawable.coveralbum_dmasive));
        coverItems.add(new CoverItem("Skrillex", R.drawable.coveralbum_skrillex));
        coverItems.add(new CoverItem("Angger Dimas", R.drawable.coveralbum_angger));

        adapter = new CoverAdapter(this, coverItems);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

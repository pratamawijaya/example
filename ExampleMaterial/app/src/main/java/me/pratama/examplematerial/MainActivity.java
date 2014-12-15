package me.pratama.examplematerial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.pratama.examplematerial.ui.FabActivity;


public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.listview)
    ListView listView;

    private ArrayAdapter<String> adapter;
    private String[] listMenu = {"FAB (Floating Action Button)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle("MaterialDesignExample");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMenu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(this, FabActivity.class));
                break;
        }
    }
}

package com.pratamawijaya.exampledatabinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.exampledatabinding.model.User;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

  @Bind(R.id.recyclerView) RecyclerView recyclerView;

  private List<User> listUser;
  private ListAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    ButterKnife.bind(this);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    listUser = new ArrayList<>();
    listUser.add(new User("Pratama", "adafs@fafas.com"));
    listUser.add(new User("Pratama 1", "adafs@fafas.com"));
    listUser.add(new User("Pratama 2", "adafs@fafas.com"));
    listUser.add(new User("Pratama 3", "adafs@fafas.com"));
    listUser.add(new User("Pratama 4", "adafs@fafas.com"));

    adapter = new ListAdapter(listUser, this);
    recyclerView.setAdapter(adapter);
  }
}

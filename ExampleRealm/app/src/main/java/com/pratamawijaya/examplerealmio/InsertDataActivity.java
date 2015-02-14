package com.pratamawijaya.examplerealmio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.realm.Realm;


public class InsertDataActivity extends ActionBarActivity {
    @InjectView(R.id.inputUserName)
    EditText username;
    @InjectView(R.id.inputAge)
    EditText age;
    @InjectView(R.id.btnSave)
    Button btnSave;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        ButterKnife.inject(this);

        realm = Realm.getInstance(this);
    }


    @OnClick(R.id.btnSave)
    public void bntSaveOnClick() {
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setName(username.getText().toString());
        user.setAge(Integer.parseInt(age.getText().toString()));
        realm.commitTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert_data, menu);
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

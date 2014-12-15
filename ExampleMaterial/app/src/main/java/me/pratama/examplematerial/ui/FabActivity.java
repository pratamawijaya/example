package me.pratama.examplematerial.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import me.pratama.examplematerial.BaseActivity;
import me.pratama.examplematerial.R;

public class FabActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        ButterKnife.inject(this);
    }
}

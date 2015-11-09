package com.pratamawijaya.examplepercentagelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

  private static final String IMAGE_URL ="http://makandiantar.com/uploads/product/6._Miso_ramen.jpg";
  @Bind(R.id.img_4_3) ImageView img43;
  @Bind(R.id.img_16_9) ImageView img169;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    Picasso.with(this).setLoggingEnabled(true);

    Picasso.with(this).load(IMAGE_URL).into(img169);
    Picasso.with(this).load(IMAGE_URL).into(img43);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
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

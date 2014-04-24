package id.pratama.example.streamingaudio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.pratama.example.streamingaudio.utils.Utils;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Intent serviceIntent;
    private Button btnPlay;
    private static boolean isMusicPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("tag","oncreate");
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        serviceIntent = new Intent(this, StreamService.class);
        isMusicPlaying = Utils.getDataBooleanFromSP(this, Utils.IS_STREAM);
        if(isMusicPlaying)
            btnPlay.setText("Stop");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view == btnPlay) {
            Log.d("playStatus", "" + isMusicPlaying);

            if (!isMusicPlaying) {
                btnPlay.setText("Stop");
                playAudio();
                Utils.setDataBooleanToSP(this,Utils.IS_STREAM,true);
            } else {
                if (isMusicPlaying) {
                    btnPlay.setText("Start");
                    Toast.makeText(this, "Stop Streaming..", Toast.LENGTH_SHORT).show();
                    stopMyService();
                    isMusicPlaying = false;
                    Utils.setDataBooleanToSP(this,Utils.IS_STREAM,false);
                }
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void playAudio() {
        Toast.makeText(this, "Start Streaming..", Toast.LENGTH_SHORT).show();
        stopMyService();
        try {
            startService(serviceIntent);
        } catch (Exception e) {
        }

    }

    private void stopMyService() {
        try {
            stopService(serviceIntent);
        } catch (Exception e) {

        }

    }
}

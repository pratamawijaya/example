package id.pratama.example.streamingaudio;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.pratama.example.streamingaudio.service.StreamService;
import id.pratama.example.streamingaudio.utils.Utils;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Intent serviceIntent;
    private Button btnPlay;
    private static boolean isStreaming = false;
    private ProgressDialog pdBuff = null;
    private boolean mBufferBroadcastIsRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);

        serviceIntent = new Intent(this, StreamService.class);
        isStreaming = Utils.getDataBooleanFromSP(this, Utils.IS_STREAM);
        if (isStreaming)
            btnPlay.setText("Stop");
    }


    @Override
    public void onClick(View view) {
        if (view == btnPlay) {
            Log.d("playStatus", "" + isStreaming);

            if (!isStreaming) {
                btnPlay.setText("Stop");
                startStreaming();
                Utils.setDataBooleanToSP(this, Utils.IS_STREAM, true);
            } else {
                if (isStreaming) {
                    btnPlay.setText("Start");
                    Toast.makeText(this, "Stop Streaming..", Toast.LENGTH_SHORT).show();
                    stopStreaming();
                    isStreaming = false;
                    Utils.setDataBooleanToSP(this, Utils.IS_STREAM, false);
                }
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mBufferBroadcastIsRegistered) {
            unregisterReceiver(broadcastBufferReceiver);
            mBufferBroadcastIsRegistered = false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mBufferBroadcastIsRegistered) {
            registerReceiver(broadcastBufferReceiver, new IntentFilter(
                    StreamService.BROADCAST_BUFFER));
            mBufferBroadcastIsRegistered = true;
        }
    }

    private void startStreaming() {
        Toast.makeText(this, "Start Streaming..", Toast.LENGTH_SHORT).show();
        stopStreaming();
        try {
            startService(serviceIntent);
        } catch (Exception e) {
        }

    }

    private void stopStreaming() {
        try {
            stopService(serviceIntent);
        } catch (Exception e) {

        }

    }

    private BroadcastReceiver broadcastBufferReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent bufferIntent) {
            showProgressDialog(bufferIntent);
        }
    };

    private void showProgressDialog(Intent bufferIntent) {
        String bufferValue = bufferIntent.getStringExtra("buffering");
        int bufferIntValue = Integer.parseInt(bufferValue);


        switch (bufferIntValue) {
            case 0:
                if (pdBuff != null) {
                    pdBuff.dismiss();
                }
                break;

            case 1:
                pdBuff = ProgressDialog.show(MainActivity.this, "",
                        "Streaming...", true);
                break;


        }
    }


}

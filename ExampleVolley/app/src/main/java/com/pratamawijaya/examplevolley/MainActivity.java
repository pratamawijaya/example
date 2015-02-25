package com.pratamawijaya.examplevolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.pratamawijaya.examplevolley.model.Ticker;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    private static final String URL = "https://vip.bitcoin.co.id/api/btc_idr/ticker";
    private Ticker ticker;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        getTickerData(URL);
    }

    private void getTickerData(String URL) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        progressDialog.dismiss();
                        Log.d("debug", "data -> " + jsonObject.toString());
                        // parsing data json menggunakan GSON
                        try {
                            ticker = new Gson().fromJson(jsonObject.getJSONObject("ticker").toString(), Ticker.class);
                            // tampilkan data
                            showDataTicker(ticker);
                        } catch (JSONException e) {
                            // error
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        // errror
                        progressDialog.dismiss();
                    }
                });
        progressDialog.show();
        BaseApplication.getInstance().addToRequestQueue(request, "tag");
    }

    private void showDataTicker(Ticker ticker) {
        Toast.makeText(this, "high " + ticker.getHigh(), Toast.LENGTH_LONG).show();
        Log.d("debug","low -> " + ticker.getLow());
        Log.d("debug","last -> " + ticker.getLast());
        Log.d("debug","buy -> " + ticker.getBuy());
    }

}

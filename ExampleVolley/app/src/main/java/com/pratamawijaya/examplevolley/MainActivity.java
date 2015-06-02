package com.pratamawijaya.examplevolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.pratamawijaya.examplevolley.model.Ticker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private static final String URL = "https://vip.bitcoin.co.id/api/btc_idr/ticker";
    private static final String M_CAMPUS = "http://mcampus.gamatechno.com/mac/jadwal/jadwal/00000/imei/000000000000000/userName/60300111003/regId/4aae68e5d38a03ea17cb4edbd0cc887e";
    private Ticker ticker;
    private ProgressDialog progressDialog;
    private long startTime, ellapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
//        getTickerData(URL);
        getDataMCampus(M_CAMPUS);
    }

    private void getDataMCampus(String URL) {
        StringRequest request = new StringRequest(Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        // get response from server
                        if (!TextUtils.isEmpty(s)) {
                            Log.d("result","res " + s);
                            long current = System.currentTimeMillis();
                            ellapsedTime = current - startTime;
                            Log.d("time", "current time : " + current);
                            Log.d("time", "elapsed time : " + ellapsedTime);
                            Toast.makeText(getApplicationContext(), "time : " + ellapsedTime, Toast.LENGTH_SHORT).show();
                        } else {
                            // error
                        }
                        // change String response to JSONObject
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        BaseApplication.getInstance().addToRequestQueue(request, "login");
        startTime = System.currentTimeMillis();
        Log.d("time", "time start " + startTime);
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
        Log.d("debug", "low -> " + ticker.getLow());
        Log.d("debug", "last -> " + ticker.getLast());
        Log.d("debug", "buy -> " + ticker.getBuy());
    }

}

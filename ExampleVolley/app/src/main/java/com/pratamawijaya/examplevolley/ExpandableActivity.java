package com.pratamawijaya.examplevolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.pratamawijaya.examplevolley.adapter.AdapterExpandable;
import com.pratamawijaya.examplevolley.model.ExpandableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExpandableActivity extends ActionBarActivity {

    private static final String FINAL_URL = "http://private-81d53-pratamalabs.apiary-mock.com/penyakit/2";
    private ExpandableListView expandableListView;

    // list model
    private List<ExpandableModel> expandableModels;


    private AdapterExpandable adapterExpandable;
    private String title;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        // initiate view
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // instance model
        expandableModels = new ArrayList<>();
        // instance adapter
        adapterExpandable = new AdapterExpandable(this, expandableModels);

        // set adapter into expandable listview
        expandableListView.setAdapter(adapterExpandable);

        getDataFromWebService(FINAL_URL);
    }


    private void getDataFromWebService(String URL) {
        StringRequest request = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String JSONString) {
                        progressDialog.dismiss();
                        Log.d("debug", "hasil ->" + JSONString);
                        // get response from server
                        // baca JSON

                        try {
                            JSONObject jsonObject = new JSONObject(JSONString);

                            // get Title
                            String title = jsonObject.getString("title");
                            // debug
                            Log.d("debug", "title -> " + title);

                            // get data informasi penyakit

                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // pertama ambil dulu text child isi dari pengertian, penanganan, penyebab
                                JSONArray jsonArrayChild = jsonArray.getJSONObject(i).getJSONArray("textchild");
                                List<String> child = new ArrayList<>();
                                for (int j = 0; j < jsonArrayChild.length(); j++) {
                                    JSONObject objChild = jsonArrayChild.getJSONObject(j);
                                    child.add(objChild.getString("text"));
                                }
                                // selesai

                                // baru ambil text
                                JSONObject objGroup = jsonArray.getJSONObject(i);
                                String group = objGroup.getString("child");

                                // masukkan kedalam list model
                                expandableModels.add(new ExpandableModel(group, child));

                            }

                            // notify adapter bahwa ada perubahan data
                            adapterExpandable.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("debug", "error -> " + e.getMessage());
                            //error parsing json
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        // error

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        progressDialog.show();
        BaseApplication.getInstance().addToRequestQueue(request, "login");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expandable, menu);
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

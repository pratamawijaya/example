package com.pratamawijaya.examplefusedlocation;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class MainActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private Location location;
    private GoogleApiClient googleApiClient;

    // params for Location Update
    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(5000)// update location every 5 second
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);// set priority, example. high accuracy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this) // connection callback
                .addOnConnectionFailedListener(this) // when connection failed
                .addApi(LocationServices.API) // called api
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    /**
     * when connected to Google Client
     *
     * @param bundle
     */
    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        if (location == null) {
            // get last location device
            location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            // Toast.
            Toast.makeText(this, "Get location user : " + location.getLatitude() + "," + location.getLongitude(), Toast.LENGTH_SHORT).show();

            // set location listener
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, REQUEST, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    /**
     * when connection failed
     *
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("tag", "locupdate");
        Toast.makeText(this, "Location update : (" + location.getLatitude() + "," + location.getLongitude() + ") accuracy:" + location.getAccuracy(), Toast.LENGTH_SHORT).show();
    }
}

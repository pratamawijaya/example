package com.pratamawijaya.examplefusedlocation;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static final int RESULT_SUCESS = 0;
    public static final int RESULT_FAIL = 1;

    public static final String TAG_RECEIVER = "receiver";
    public static final String TAG_LOCATION = "location";
    public static final String TAG_RESULT = "result";


    @InjectView(R.id.alamat)
    TextView alamat;

    private AddressResultReceiver addressResultReceiver;
    private Location location;
    private GoogleApiClient googleApiClient;
    private boolean locationUpdate = false;

    // params for Location Update
    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(2000)// update location every 5 second
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);// set priority, example. high accuracy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        // instance addressResultReceiver
        addressResultReceiver = new AddressResultReceiver(new Handler());

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
            if (locationUpdate)
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

            if (location != null) {
                Toast.makeText(this, "Get location user : " + location.getLatitude() + "," + location.getLongitude(), Toast.LENGTH_SHORT).show();
                //get address
                startIntentService();

                LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, REQUEST, this);
            }
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
        // if fail get location
        // trigger location update
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, REQUEST, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("tag", "locupdate");
        Toast.makeText(this, "Location update : (" + location.getLatitude() + "," + location.getLongitude() + ") accuracy:" + location.getAccuracy(), Toast.LENGTH_SHORT).show();
    }

    protected void startIntentService() {
        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(TAG_RECEIVER, addressResultReceiver);
        intent.putExtra(TAG_LOCATION, location);
        startService(intent);
    }

    class AddressResultReceiver extends ResultReceiver {
        AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultCode == RESULT_SUCESS) {
                // get adress
                Log.d("debug", "get data : " + resultData.getString(TAG_RESULT));
                alamat.setText("" + resultData.getString(TAG_RESULT));
            }
        }
    }

}

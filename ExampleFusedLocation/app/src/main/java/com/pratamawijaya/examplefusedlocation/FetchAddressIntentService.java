package com.pratamawijaya.examplefusedlocation;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by pratama on 2/14/15.
 */
public class FetchAddressIntentService extends IntentService {
    protected ResultReceiver receiver;

    public FetchAddressIntentService() {
        super("fetchaddress");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String error = "";

        // get location lat lng from activity
        Location location = intent.getParcelableExtra(MainActivity.TAG_LOCATION);
        receiver = intent.getParcelableExtra(MainActivity.TAG_RECEIVER);

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> listAddress = null;
        try {
            Log.d("debug", "get location... ");
            listAddress = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            //error
        } catch (IllegalArgumentException ex) {
            // error
        }

        if (listAddress == null && listAddress.size() == 0) {
            // gagal mendapatkan alamat
            Log.d("debug", "gagal dapat alamat...");
            deliverResultToReceiver(MainActivity.RESULT_FAIL, "no adress fouund");
        } else {
            Log.d("debug", "berhasil dapat alamat...");
            // dapat alamat
            Address address = listAddress.get(0);
            ArrayList<String> addressFrag = new ArrayList<>();
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                addressFrag.add(address.getAddressLine(i));
            }

            // deliver
            deliverResultToReceiver(MainActivity.RESULT_SUCESS,
                    TextUtils.join(System.getProperty("line.separator"),
                            addressFrag));
        }
    }

    /**
     * kirim hasil ke activity
     *
     * @param resultCode
     * @param message
     */
    private void deliverResultToReceiver(int resultCode, String message) {
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.TAG_RESULT, message);
        receiver.send(resultCode, bundle);
    }
}

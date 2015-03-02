package com.pratamawijaya.examplematerialnavdrawerneokre.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pratamawijaya.examplematerialnavdrawerneokre.R;

/**
 * Created by pratama on 3/2/15.
 */
public class NewsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_news, container, false);
        return v;

    }
}

package com.pratamawijaya.bbmmaterial.model;

import android.support.v4.app.Fragment;

/**
 * Created by pratama on 6/27/15.
 */
public class FragmentHomeItem {
    private String title;
    private Fragment fragment;
    private int icon;


    public FragmentHomeItem() {
    }

    public FragmentHomeItem(String title, Fragment fragment, int icon) {
        this.title = title;
        this.fragment = fragment;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}

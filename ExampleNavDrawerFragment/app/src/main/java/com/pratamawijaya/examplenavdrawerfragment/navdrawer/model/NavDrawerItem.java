package com.pratamawijaya.examplenavdrawerfragment.navdrawer.model;

/**
 * Created by pratama on 3/6/15.
 */
public class NavDrawerItem {
    private String title;
    private int icon;

    public NavDrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

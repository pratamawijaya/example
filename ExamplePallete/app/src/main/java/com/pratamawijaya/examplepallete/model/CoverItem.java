package com.pratamawijaya.examplepallete.model;

/**
 * Created by pratama on 12/11/14.
 */
public class CoverItem {
    private String tilte;
    private int thumbnail;

    public CoverItem(String tilte, int thumbnail) {
        this.tilte = tilte;
        this.thumbnail = thumbnail;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

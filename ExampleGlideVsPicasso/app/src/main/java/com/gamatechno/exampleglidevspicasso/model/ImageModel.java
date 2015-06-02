package com.gamatechno.exampleglidevspicasso.model;

/**
 * Created by pratama on 3/28/15.
 */
public class ImageModel {
    private String title;
    private String imgUrl;

    public ImageModel() {
    }

    public ImageModel(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

package me.pratama.examplematerial.model;

/**
 * Created by pratama on 12/24/14.
 */
public class Singer {
    private int thumb;
    private String name;

    public Singer(int thumb, String name) {
        this.thumb = thumb;
        this.name = name;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumb() {
        return thumb;
    }

    public String getName() {
        return name;
    }
}

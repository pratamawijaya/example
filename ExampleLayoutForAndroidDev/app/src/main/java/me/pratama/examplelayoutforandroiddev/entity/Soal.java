package me.pratama.examplelayoutforandroiddev.entity;

/**
 * Created by pratama on 10/26/14.
 */
public class Soal {
    private String nomor;
    private int image;


    public Soal() {
    }

    public Soal(String nomor, int image) {
        this.nomor = nomor;
        this.image = image;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

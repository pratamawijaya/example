package id.pratama.example.parse.entity;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by pratama on 4/21/14.
 */
@ParseClassName("book")
public class Book extends ParseObject {

    private String id;
    private String judul;
    private String pengarang;
    private String penerbit;

    public Book(String id, String judul, String pengarang, String penerbit) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
    }

    public String getId() {
        return getString("id");
    }

    public void setId(String id) {
        put("id", id);
    }

    public String getJudul() {

        return getString("judul");
    }

    public void setJudul(String judul) {

        put("judul", judul);
    }

    public String getPengarang() {

        return getString("pengarang");
    }

    public void setPengarang(String pengarang) {

        put("pengarang", pengarang);
    }

    public String getPenerbit() {
        return getString("penerbit");
    }

    public void setPenerbit(String penerbit) {
        put("penerbit", penerbit);
    }
}

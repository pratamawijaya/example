package com.pratamawijaya.exampleexpandable.model;

import java.util.List;

/**
 * Created by pratama on 3/4/15.
 */
public class Header {
    private int id;
    private String text;
    private List<Child> childList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}

package com.pratamawijaya.examplevolley.model;

import java.util.List;

/**
 * Created by pratama on 3/6/15.
 */
public class ExpandableModel {
    private String groupText;
    private List<String> childText;

    public ExpandableModel(String groupText, List<String> childText) {
        this.groupText = groupText;
        this.childText = childText;
    }

    public String getGroupText() {
        return groupText;
    }

    public void setGroupText(String groupText) {
        this.groupText = groupText;
    }

    public List<String> getChildText() {
        return childText;
    }

    public void setChildText(List<String> childText) {
        this.childText = childText;
    }
}

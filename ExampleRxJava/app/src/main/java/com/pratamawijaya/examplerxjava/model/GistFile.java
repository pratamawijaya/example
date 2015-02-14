package com.pratamawijaya.examplerxjava.model;

import com.google.gson.annotations.Expose;

/**
 * Created by pratama on 12/18/14.
 */
public class GistFile {
    @Expose
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

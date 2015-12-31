package com.pratamawijaya.examplerxjava.model;

import com.google.gson.annotations.Expose;

/**
 * Created by pratama on 12/18/14.
 */
public class Gist {
  @Expose private String id;

  @Expose private String description;

  @Expose private String html_url;

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getHtml_url() {
    return html_url;
  }
}

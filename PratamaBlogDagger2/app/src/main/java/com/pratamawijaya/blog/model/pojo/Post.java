package com.pratamawijaya.blog.model.pojo;

import java.util.List;
import org.joda.time.DateTime;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
public class Post {
  public int id;
  public String type;
  public String slug;
  public String url;
  public String title;
  public String content;
  public String excerpt;
  public DateTime date;
  public DateTime modified;
  public List<Category> categories;
  public Author author;
  public List<Attachment> attachments;
}

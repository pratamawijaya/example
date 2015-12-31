package com.pratamawijaya.blog.model.database;

import io.realm.RealmObject;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/1/16
 * Project : PratamaBlogDagger2
 */
public class ImagesTable extends RealmObject {
  private ImagesFullTable imagesFullTable;
  private ImagesLargeTable imagesLargeTable;
  private ImagesMediumLargeTable imagesMediumLargeTable;
  private ImagesMediumTable imagesMediumTable;
  private ImagesThumbnailTable imagesThumbnailTable;

  public ImagesTable() {
  }

  public ImagesFullTable getImagesFullTable() {
    return imagesFullTable;
  }

  public void setImagesFullTable(ImagesFullTable imagesFullTable) {
    this.imagesFullTable = imagesFullTable;
  }

  public ImagesLargeTable getImagesLargeTable() {
    return imagesLargeTable;
  }

  public void setImagesLargeTable(ImagesLargeTable imagesLargeTable) {
    this.imagesLargeTable = imagesLargeTable;
  }

  public ImagesMediumLargeTable getImagesMediumLargeTable() {
    return imagesMediumLargeTable;
  }

  public void setImagesMediumLargeTable(ImagesMediumLargeTable imagesMediumLargeTable) {
    this.imagesMediumLargeTable = imagesMediumLargeTable;
  }

  public ImagesMediumTable getImagesMediumTable() {
    return imagesMediumTable;
  }

  public void setImagesMediumTable(ImagesMediumTable imagesMediumTable) {
    this.imagesMediumTable = imagesMediumTable;
  }

  public ImagesThumbnailTable getImagesThumbnailTable() {
    return imagesThumbnailTable;
  }

  public void setImagesThumbnailTable(ImagesThumbnailTable imagesThumbnailTable) {
    this.imagesThumbnailTable = imagesThumbnailTable;
  }
}

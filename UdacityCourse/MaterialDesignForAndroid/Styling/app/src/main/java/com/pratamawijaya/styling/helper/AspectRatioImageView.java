package com.pratamawijaya.styling.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/24/15
 * Project : Styling
 */
public class AspectRatioImageView extends ImageView {
  public AspectRatioImageView(Context context) {
    super(context);
  }

  public AspectRatioImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width = MeasureSpec.getSize(widthMeasureSpec);
    int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
    setMeasuredDimension(width, height);
    //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}

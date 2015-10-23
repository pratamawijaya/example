package com.pratamawijaya.styling.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/24/15
 * Project : Styling
 *
 * 3:2 Imageview
 */
public class ThreeTwoImageview extends ImageView {
  public ThreeTwoImageview(Context context) {
    super(context);
  }

  public ThreeTwoImageview(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ThreeTwoImageview(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int threeTwoHeight = MeasureSpec.getSize(widthMeasureSpec) * 2 / 3;

    int threeTwoHeightSpec = MeasureSpec.makeMeasureSpec(threeTwoHeight, MeasureSpec.EXACTLY);

    super.onMeasure(widthMeasureSpec, threeTwoHeightSpec);
  }
}

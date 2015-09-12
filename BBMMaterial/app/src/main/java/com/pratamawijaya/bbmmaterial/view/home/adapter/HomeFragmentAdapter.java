package com.pratamawijaya.bbmmaterial.view.home.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.pratamawijaya.bbmmaterial.R;
import com.pratamawijaya.bbmmaterial.model.FragmentHomeItem;
import java.util.List;

/**
 * Created by pratama on 6/27/15.
 */
public class HomeFragmentAdapter extends FragmentStatePagerAdapter {
  private List<FragmentHomeItem> fragmentHomeItems;
  private Context context;

  public HomeFragmentAdapter(Context context, FragmentManager fm,
      List<FragmentHomeItem> fragmentHomeItems) {
    super(fm);
    this.context = context;
    this.fragmentHomeItems = fragmentHomeItems;
  }

  @Override public Fragment getItem(int position) {
    return fragmentHomeItems.get(position).getFragment();
  }

  @Override public int getCount() {
    return fragmentHomeItems.size();
  }

  //    @Override
  //    public CharSequence getPageTitle(int position) {
  //        return fragmentHomeItems.get(position).getTitle();
  //    }

  public View getTabView(int position) {
    View tab = LayoutInflater.from(context).inflate(R.layout.tabbar_view, null);
    ImageView tabImage = (ImageView) tab.findViewById(R.id.tabImage);
    tabImage.setBackgroundResource(fragmentHomeItems.get(position).getIcon());
    if (position == 0) {
      tab.setSelected(true);
    }
    return tab;
  }
}

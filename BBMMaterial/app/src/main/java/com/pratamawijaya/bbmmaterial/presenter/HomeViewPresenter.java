package com.pratamawijaya.bbmmaterial.presenter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.pratamawijaya.bbmmaterial.R;
import com.pratamawijaya.bbmmaterial.model.FragmentHomeItem;
import com.pratamawijaya.bbmmaterial.utils.RoundedTransformation;
import com.pratamawijaya.bbmmaterial.view.bbmchat.BBMChatFragment;
import com.pratamawijaya.bbmmaterial.view.bbmcontact.BBMContactFragment;
import com.pratamawijaya.bbmmaterial.view.bbmfeed.BBMFeedFragment;
import com.pratamawijaya.bbmmaterial.view.bbmgroups.BBMGroupFragment;
import com.pratamawijaya.bbmmaterial.view.home.HomeViewInterface;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratama on 6/27/15.
 */
public class HomeViewPresenter {

  private HomeViewInterface view;
  private List<FragmentHomeItem> fragmentHomeItems;
  private final String RAISA_URL =
      "http://urbanradiobandung.com/home/wp-content/uploads/2015/06/raisa.jpg";

  public HomeViewPresenter(HomeViewInterface view) {
    this.view = view;
  }

  public void initPresenter() {
    setupFragment();
  }

  public void setupFragment() {
    fragmentHomeItems = new ArrayList<>();
    fragmentHomeItems.add(
        new FragmentHomeItem("BBM Chat", new BBMChatFragment(), R.drawable.ic_chat_white_24dp));
    fragmentHomeItems.add(
        new FragmentHomeItem("BBM Feeds", new BBMFeedFragment(), R.drawable.ic_cloud_white_24dp));
    fragmentHomeItems.add(new FragmentHomeItem("BBM Contact", new BBMContactFragment(),
        R.drawable.ic_person_white_24dp));
    fragmentHomeItems.add(
        new FragmentHomeItem("BBM Groups", new BBMGroupFragment(), R.drawable.ic_group_white_24dp));

    view.setupViewPager(fragmentHomeItems);
  }

  public void loadDataUser(Context context, ImageView userPicture, TextView userName,
      TextView userStatus) {
    Picasso.with(context).load(RAISA_URL).transform(new RoundedTransformation()).into(userPicture);

    userName.setText("Raisa Andriana");
    userStatus.setText("Sayang aku kangen T,T");
  }
}

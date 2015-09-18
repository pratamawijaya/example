package com.pratamawijaya.instagramlogin.views.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.instagramlogin.R;
import com.pratamawijaya.instagramlogin.models.Post;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/18/15
 * Project : InstagramLogin
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

  private Context context;
  private List<Post> listData;

  public FeedAdapter(Context context) {
    this.context = context;
  }

  public List<Post> getListData() {
    return listData;
  }

  public void setListData(List<Post> listData) {
    this.listData = listData;
  }

  @Override public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new FeedHolder(LayoutInflater.from(context).inflate(R.layout.item_post, parent, false));
  }

  @Override public void onBindViewHolder(FeedHolder holder, int position) {
    Picasso.with(context)
        .load(listData.get(position).getImages().getStandardResolution().getUrl())
        .into(holder.img);
  }

  @Override public int getItemCount() {
    return listData.size();
  }

  public class FeedHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.thumb) ImageView img;

    public FeedHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

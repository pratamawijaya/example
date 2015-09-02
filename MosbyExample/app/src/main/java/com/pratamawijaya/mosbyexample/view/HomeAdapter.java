package com.pratamawijaya.mosbyexample.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.mosbyexample.R;
import com.pratamawijaya.mosbyexample.model.Post;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterHolder> {

  private Context context;
  private List<Post> posts;

  public HomeAdapter(Context context) {
    this.context = context;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override public HomeAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
    return new HomeAdapterHolder(v);
  }

  @Override public void onBindViewHolder(HomeAdapterHolder holder, int position) {
    holder.title.setText("" + posts.get(position).getTitle());
  }

  @Override public int getItemCount() {
    return posts.size();
  }

  public class HomeAdapterHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.txtTitle) TextView title;

    public HomeAdapterHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

package com.pratamawijaya.exampledatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pratamawijaya.exampledatabinding.model.User;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/2/15
 * Project : ExampleDataBinding
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemHolder> {
  private List<User> userList;
  private Context context;

  public ListAdapter(List<User> userList, Context context) {
    this.userList = userList;
    this.context = context;
  }

  @Override public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ListItemHolder(
        LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
  }

  @Override public void onBindViewHolder(ListItemHolder holder, int position) {
    holder.getBinding()
        .setVariable(com.pratamawijaya.exampledatabinding.BR.user, userList.get(position));
    holder.getBinding().executePendingBindings();
  }

  @Override public int getItemCount() {
    return userList.size();
  }

  public class ListItemHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public ListItemHolder(View itemView) {
      super(itemView);
      binding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
      return binding;
    }
  }
}

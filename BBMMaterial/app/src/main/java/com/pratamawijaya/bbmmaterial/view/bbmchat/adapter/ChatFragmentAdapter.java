package com.pratamawijaya.bbmmaterial.view.bbmchat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.bbmmaterial.R;
import com.pratamawijaya.bbmmaterial.model.Chat;
import com.pratamawijaya.bbmmaterial.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by pratama on 6/27/15.
 */
public class ChatFragmentAdapter
    extends RecyclerView.Adapter<ChatFragmentAdapter.ChatFragmentHolder> {
  private Context context;
  private List<Chat> chats;

  public ChatFragmentAdapter(Context context, List<Chat> chats) {
    this.context = context;
    this.chats = chats;
  }

  @Override public ChatFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
    return new ChatFragmentHolder(v);
  }

  @Override public void onBindViewHolder(ChatFragmentHolder holder, int position) {
    holder.userName.setText(chats.get(position).getUserName());
    holder.userMessage.setText(chats.get(position).getUserMessage());
    holder.messageTime.setText(chats.get(position).getMessageTime());

    Picasso.with(context)
        .load(chats.get(position).getUserPicture())
        .transform(new RoundedTransformation())
        .into(holder.userPicture);
  }

  @Override public int getItemCount() {
    return chats.size();
  }

  public static class ChatFragmentHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.userPicture) ImageView userPicture;
    @Bind(R.id.userName) TextView userName;
    @Bind(R.id.userMessage) TextView userMessage;
    @Bind(R.id.messageStatus) TextView messageStatus;
    @Bind(R.id.messageTime) TextView messageTime;

    public ChatFragmentHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

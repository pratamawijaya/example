package com.pratamawijaya.bbmmaterial.view.bbmchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.bbmmaterial.R;
import com.pratamawijaya.bbmmaterial.model.Chat;
import com.pratamawijaya.bbmmaterial.presenter.BBMChatPresenter;
import com.pratamawijaya.bbmmaterial.view.bbmchat.adapter.ChatFragmentAdapter;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BBMChatFragment extends Fragment implements BBMChatFragmentInterface {

  @Bind(R.id.recylerView) RecyclerView recyclerView;

  private BBMChatPresenter presenter;
  private ChatFragmentAdapter adapter;

  public BBMChatFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_bbmchat, container, false);
    ButterKnife.bind(this, v);

    presenter = new BBMChatPresenter(this);
    presenter.loadData();
    return v;
  }

  @Override public void loadData(List<Chat> chats) {
    adapter = new ChatFragmentAdapter(getActivity(), chats);
    recyclerView.setAdapter(adapter);
  }
}

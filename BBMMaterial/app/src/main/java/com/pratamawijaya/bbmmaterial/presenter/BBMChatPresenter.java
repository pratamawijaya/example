package com.pratamawijaya.bbmmaterial.presenter;

import com.pratamawijaya.bbmmaterial.model.Chat;
import com.pratamawijaya.bbmmaterial.view.bbmchat.BBMChatFragmentInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratama on 6/28/15.
 */
public class BBMChatPresenter {
  private BBMChatFragmentInterface view;
  private List<Chat> chats;

  public BBMChatPresenter(BBMChatFragmentInterface view) {
    this.view = view;
  }

  /**
   * load data from source
   */
  public void loadData() {
    chats = new ArrayList<>();
    chats.add(new Chat("Pratama Nur Wijaya", "R", "19:49",
        "https://lh5.googleusercontent.com/-3UYageA-pkw/VVIX4DoQTLI/AAAAAAAAFts/fnx6K2GbEfc/s611-no/IMG_20150425_104713.jpg",
        "Jangan lupa makan yah :*"));

    chats.add(new Chat("Cita citata", "R", "19:45",
        "http://cdn.klimg.com/resized/630x/g/cantiknya_pose_selfie_cita_citata_penyanyi_sakitnya_tuh_disini/cita_citata-20141008-002-rita.jpg",
        "Say jangan lupa nanti yah.."));

    chats.add(new Chat("Isyana Sarasvati", "R", "19:42",
        "http://mtv.id/wp-content/uploads/2015/01/isyana.jpg", "Sampai besok malem ya teh :*"));

    view.loadData(chats);
  }
}

package com.pratamawijaya.examplematerialnavdrawerneokre;

import android.os.Bundle;

import com.pratamawijaya.examplematerialnavdrawerneokre.fragment.HomeFragment;
import com.pratamawijaya.examplematerialnavdrawerneokre.fragment.NewsFragment;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;


public class MainActivity extends MaterialNavigationDrawer {

    @Override
    public void init(Bundle bundle) {
        // add sections
        MaterialSection sectionHome = newSection("Home", new HomeFragment());
        MaterialSection sectionNews = newSection("News", new NewsFragment());

        // add account
        MaterialAccount account = new MaterialAccount(this.getResources(), "Pratama", "dev~", R.drawable.babymetal, R.drawable.bg_account);


        addAccount(account);

        addSection(sectionHome);
        addSection(sectionNews);
    }

}

package com.pratamawijaya.blog.data;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/1/16
 * Project : PratamaBlogDagger2
 */
public class Migration implements RealmMigration {
  @Override public void migrate(final DynamicRealm dynamicRealm, long oldVer, long newVer) {
    RealmSchema schema = dynamicRealm.getSchema();
    if (oldVer == 0) {
      Timber.d("migrate(): oldver" + oldVer);
    }
  }
}

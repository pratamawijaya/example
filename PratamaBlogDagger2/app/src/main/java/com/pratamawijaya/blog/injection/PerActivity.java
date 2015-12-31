package com.pratamawijaya.blog.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}

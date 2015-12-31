package com.pratamawijaya.blog.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 12/31/15
 * Project : PratamaBlogDagger2
 */
@Qualifier @Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}

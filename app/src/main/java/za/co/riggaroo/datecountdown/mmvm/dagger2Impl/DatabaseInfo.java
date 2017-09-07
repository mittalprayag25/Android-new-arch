package za.co.riggaroo.datecountdown.mmvm.dagger2Impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by pmittal on 28/08/17.
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface DatabaseInfo {
}

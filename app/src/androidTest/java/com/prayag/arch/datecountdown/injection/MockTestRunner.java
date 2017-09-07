package com.prayag.arch.injection;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.prayag.arch.MockCountDownApplication;

/**
 * @author rebeccafranks
 * @since 2017/05/12.
 */

public class MockTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, MockCountDownApplication.class.getName(), context);
    }
}

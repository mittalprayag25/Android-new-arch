package com.prayag.arch;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import com.prayag.arch.application.MockCountDownApplication;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MockTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, MockCountDownApplication.class.getName(), context);
    }

    @Test
    public void addEvent() {
        assertEquals(1, 1);
    }

}

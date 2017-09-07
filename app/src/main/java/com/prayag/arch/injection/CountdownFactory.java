package com.prayag.arch.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.prayag.arch.CountdownApplication;

/**
 * @author rebeccafranks
 * @since 2017/05/10.
 */

public class CountdownFactory extends ViewModelProvider.NewInstanceFactory {

    private CountdownApplication application;

    public CountdownFactory(CountdownApplication application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if (t instanceof CountdownComponent.Injectable) {
            ((CountdownComponent.Injectable) t).inject(application.getCountDownComponent());
        }
        return t;
    }
}

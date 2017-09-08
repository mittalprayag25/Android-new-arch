package com.prayag.arch.application.injection;

import javax.inject.Singleton;

import dagger.Component;
import com.prayag.arch.event.viewmodel.AddEventViewModel;
import com.prayag.arch.event.viewmodel.EventListViewModel;

/**
 * @author rebeccafranks
 * @since 2017/05/11.
 */
@Singleton
@Component(modules = {CountdownModule.class})
public interface CountdownComponent {

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }
}

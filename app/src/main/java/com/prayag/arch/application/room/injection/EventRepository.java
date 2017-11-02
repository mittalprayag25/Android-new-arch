package com.prayag.arch.application.room.injection;


import android.arch.lifecycle.LiveData;

import com.prayag.arch.application.room.entity.Event;

import java.util.List;

import io.reactivex.Completable;

/**
 * @author rebeccafranks
 * @since 2017/04/21.
 */
public interface EventRepository {

    Completable addEvent(Event event);

    LiveData<List<Event>> getEvents();

    Completable deleteEvent(Event event);


}

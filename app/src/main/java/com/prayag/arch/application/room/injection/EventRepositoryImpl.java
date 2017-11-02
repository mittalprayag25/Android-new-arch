package com.prayag.arch.application.room.injection;

import android.arch.lifecycle.LiveData;

import com.prayag.arch.application.room.AppDatabase;
import com.prayag.arch.application.room.entity.Event;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;


public class EventRepositoryImpl implements EventRepository {

    @Inject
    AppDatabase appDatabase;

    public EventRepositoryImpl(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Completable addEvent(Event event) {
        return Completable.fromAction(() -> appDatabase.eventDao().addEvent(event));
    }

    @Override
    public LiveData<List<Event>> getEvents() {
        //Here is where we would do more complex logic, like getting events from a cache
        //then inserting into the database etc. In this example we just go straight to the dao.
        return appDatabase.eventDao().getEvents(LocalDateTime.now());
    }

    @Override
    public Completable deleteEvent(Event event) {
        return Completable.fromAction(() -> appDatabase.eventDao().deleteEvent(event));
    }


}

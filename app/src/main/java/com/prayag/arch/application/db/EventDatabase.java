package com.prayag.arch.application.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.prayag.arch.event.dao.EventDao;
import com.prayag.arch.application.entity.Event;

@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}

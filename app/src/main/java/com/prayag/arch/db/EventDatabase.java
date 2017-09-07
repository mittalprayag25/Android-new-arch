package com.prayag.arch.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.prayag.arch.dao.EventDao;
import com.prayag.arch.entity.Event;

@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}

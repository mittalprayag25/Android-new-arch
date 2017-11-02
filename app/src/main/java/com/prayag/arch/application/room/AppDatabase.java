package com.prayag.arch.application.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.prayag.arch.application.room.converter.DateTypeConverter;
import com.prayag.arch.application.room.dao.CitizenDao;
import com.prayag.arch.application.room.dao.EventDao;
import com.prayag.arch.application.room.entity.Event;
import com.prayag.arch.application.room.entity.Citizen;

/**
 * Created by pmittal on 02/11/17.
 */
@Database(entities = {Event.class, Citizen.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase  extends RoomDatabase {

    public abstract EventDao eventDao();
    public abstract CitizenDao citizenDao();

    public static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "college")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
}

package com.prayag.arch.application.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.prayag.arch.application.room.converter.DataTypeConverter;
import com.prayag.arch.application.room.dao.StarShipDao;
import com.prayag.arch.application.room.dao.EventDao;
import com.prayag.arch.application.room.entity.Event;
import com.prayag.arch.application.room.entity.StarshipEntity;

/**
 * Created by pmittal on 02/11/17.
 */
@Database(entities = {Event.class, StarshipEntity.class}, version = 2)
@TypeConverters(DataTypeConverter.class)
public abstract class AppDatabase  extends RoomDatabase {

    public abstract EventDao eventDao();
    public abstract StarShipDao starshipsDao();

    public static AppDatabase appDatabase;

    /**
     *
     * @param context
     * @return
     */
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

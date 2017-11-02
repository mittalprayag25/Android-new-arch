package com.prayag.arch.application.room;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by pmittal on 02/11/17.
 */

public class AppDatabase {

    public static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "database-name").build();
        }
        return appDatabase;
    }
}

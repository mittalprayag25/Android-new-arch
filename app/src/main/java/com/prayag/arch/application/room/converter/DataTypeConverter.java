package com.prayag.arch.application.room.converter;


import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import com.google.gson.Gson;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

import java.util.Arrays;

public class DataTypeConverter {

    @TypeConverter
    public static LocalDateTime toDate(Long timestamp) {
        return timestamp == null ? null : LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0));
    }

    @TypeConverter
    public static Long toTimestamp(LocalDateTime date) {
        return date == null ? null : date.toInstant(ZoneOffset.ofTotalSeconds(0)).getEpochSecond();
    }

    @TypeConverter
    public static String jsonArrayToString(String[] arr){
        Gson gson = new Gson();
        String json = gson.toJson(arr);
        Log.d("JSON DATA", json);
        return json;
    }
}


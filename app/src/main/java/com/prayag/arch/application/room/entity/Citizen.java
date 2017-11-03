package com.prayag.arch.application.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pmittal on 31/10/17.
 */

@Entity(tableName = Citizen.TABLE_NAME)
public class Citizen {
    public static final String TABLE_NAME = "citizen";
    private String type;

    @PrimaryKey(autoGenerate = true)
    private int requestId;

    private String message;
    private String dueDate;

    /**
     *
     * @param type
     * @param requestId
     * @param message
     * @param dueDate
     */
    public Citizen(String type, int requestId, String message, String dueDate) {
        this.type = type;
        this.requestId = requestId;
        this.message = message;
        this.dueDate = dueDate;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

package com.prayag.arch.sla.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 31/10/17.
 */

@Singleton
public class CitizenAlert {

    String type;
    int requestId;
    String message;
    String dueDate;

    @Inject
    public CitizenAlert(String type, int requestId, String message, String dueDate) {
        this.type = type;
        this.requestId = requestId;
        this.message = message;
        this.dueDate = dueDate;
    }

    public CitizenAlert() {

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

package com.starter.project.model;

import com.starter.project.model.audit.DateAudit;
import lombok.Data;

@Data
public class Event extends DateAudit {

    private String eventID;
    private String eventName;
    private String eventDescription
}

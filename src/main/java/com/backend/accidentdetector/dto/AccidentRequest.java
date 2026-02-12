package com.backend.accidentdetector.dto;

public class AccidentRequest {

    // This should be "lat,lng"
    private String location;
    private String severity;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}


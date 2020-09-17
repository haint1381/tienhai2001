package com.codegym.model;

public class Status {
    String statusName;

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Status() {
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

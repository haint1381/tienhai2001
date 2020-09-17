package com.codegym.model;

public class RentalSpaceManagement {
   private String id;
    private String statusName;
    private   String acreage;
    private String floors;
    private String typeOfPremises;
    private String price;
    private String startDay;
    private String endDate;

    public RentalSpaceManagement(String id, String statusName, String acreage, String floors, String typeOfPremises, String price, String startDay, String endDate) {
        this.id = id;
        this.statusName = statusName;
        this.acreage = acreage;
        this.floors = floors;
        this.typeOfPremises = typeOfPremises;
        this.price = price;
        this.startDay = startDay;
        this.endDate = endDate;
    }

    public RentalSpaceManagement() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getTypeOfPremises() {
        return typeOfPremises;
    }

    public void setTypeOfPremises(String typeOfPremises) {
        this.typeOfPremises = typeOfPremises;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

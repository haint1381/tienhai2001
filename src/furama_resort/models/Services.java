package furama_resort.models;

import java.util.List;

public abstract class Services {
    private String id;
    private String name;
    private String area;
    private String price;
    private String peopleMax;
    private String typeOfRent;


    public Services(String id, String name, String area, String price, String peopleMax, String typeOfRent) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.peopleMax = peopleMax;
        this.typeOfRent = typeOfRent;
    }

    public Services() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(String peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public abstract String showInfor();
}

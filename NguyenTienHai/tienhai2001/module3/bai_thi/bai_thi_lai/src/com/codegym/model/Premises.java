package com.codegym.model;

public class Premises {
    String typeOfPremises;

    public Premises(String typeOfPremises) {
        this.typeOfPremises = typeOfPremises;
    }

    public Premises() {
    }

    public String getTypeOfPremises() {
        return typeOfPremises;
    }

    public void setTypeOfPremises(String typeOfPremises) {
        this.typeOfPremises = typeOfPremises;
    }
}

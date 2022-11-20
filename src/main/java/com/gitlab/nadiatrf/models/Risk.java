package com.gitlab.nadiatrf.models;


import java.util.List;

public class Risk implements IRisk{
    public String title;
    public Integer amountOfRisk;

    public Risk(Integer amountOfRisk) {

        this.amountOfRisk = amountOfRisk;
    }
    public Risk() {}

    public List<Risk> useSum(Integer newSum) {
        return null;
    }

}

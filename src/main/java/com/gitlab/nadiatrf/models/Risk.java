package com.gitlab.nadiatrf.models;


import java.util.List;

public class Risk {
    public String title;
    public Integer amountOfRisk;

    public Risk(String title,Integer amountOfRisk) {
        this.title = title;
        this.amountOfRisk = amountOfRisk;
    }
    public Risk() {}

    public void useSum(Integer newSum) {

    }

}

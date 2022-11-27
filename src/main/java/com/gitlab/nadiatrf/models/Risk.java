package com.gitlab.nadiatrf.models;


import java.math.BigDecimal;
import java.util.List;

public class Risk implements IRisk {
    public String title;
    public BigDecimal amountOfRisk;

    public Risk(BigDecimal amountOfRisk) {

        this.amountOfRisk = amountOfRisk;
    }

    public Risk() {
    }

    public void useSum(BigDecimal newSum) {

    }

}

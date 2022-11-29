package com.gitlab.nadiatrf.models;


import java.math.BigDecimal;

public class Risk implements RiskCompositor {
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

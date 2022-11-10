package com.gitlab.nadiatrf.models;

import java.util.Objects;

public class Risk {

    private Integer amountOfRisk;

    public Risk(Integer amountOfRisk) {
        this.amountOfRisk = amountOfRisk;
    }
    public Risk() {}

    public Integer getAmountOfRisk() {
        return amountOfRisk;
    }

    public void setAmountOfRisk(Integer amountOfRisk) {
        this.amountOfRisk = amountOfRisk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Risk risk = (Risk) o;
        return Objects.equals(amountOfRisk, risk.amountOfRisk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfRisk);
    }
}

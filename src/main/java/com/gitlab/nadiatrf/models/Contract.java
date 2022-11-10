package com.gitlab.nadiatrf.models;

import java.util.List;

public class Contract {
    private String formula;
    private List<Integer> options;

    public Contract(String formula, List<Integer> options) {
        this.formula = formula;
        this.options = options;
    }

    public Contract(){}

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }
}

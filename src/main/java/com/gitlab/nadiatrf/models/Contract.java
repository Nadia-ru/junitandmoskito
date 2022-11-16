package com.gitlab.nadiatrf.models;

import java.util.List;

public class Contract {
    public String formula;
    public List<Integer> options;

    public Contract(String formula, List<Integer> options) {
        this.formula = formula;
        this.options = options;
    }


}

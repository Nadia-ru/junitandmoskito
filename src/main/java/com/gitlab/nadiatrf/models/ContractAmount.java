package com.gitlab.nadiatrf.models;

import java.util.List;

public class ContractAmount {
   public Integer amount;
   public int countOfRisk;
   public List<Risk> risks;

    public ContractAmount(Integer amount, int countOfRisk) {
        this.amount = amount;
        this.countOfRisk = countOfRisk;
    }

    public void useSum(Integer newSum, List<String> risks) {

    }
}

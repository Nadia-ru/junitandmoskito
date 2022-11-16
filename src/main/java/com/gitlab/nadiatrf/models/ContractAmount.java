package com.gitlab.nadiatrf.models;

import java.util.ArrayList;
import java.util.List;

public class ContractAmount {
    private Integer amount;
    private List<String> riskList;
    private List<Risk> risks;


    public ContractAmount(Integer amount, List<String> riskList) {
        this.amount = amount;
        this.riskList = riskList;
        useSum(amount,riskList);
    }

    public List<String> getRiskList() {
        return riskList;
    }

    public void setRiskList(List<String> riskList) {
        this.riskList = riskList;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Risk> getRisks() {
        return risks;
    }

    public void useSum(Integer newSum, List<String> risks) {

    }
}

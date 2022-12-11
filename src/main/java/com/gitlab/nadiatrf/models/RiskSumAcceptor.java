package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

public class RiskSumAcceptor implements RiskSummator {

    @Override
    public void sendSum(BigDecimal sum, List<RiskCompositor> risks) {
        double count = risks.size();
        BigDecimal countRisks = new BigDecimal(count);
        BigDecimal zero = new BigDecimal("0.00");
        BigDecimal sub = new BigDecimal("0.01");
        BigDecimal ost = new BigDecimal("0.00");
        BigDecimal divideBy = countRisks.multiply(sub);
        sum = sum.setScale(2);

        // цикл нам нужен ля вычисения остатка на добавление его в последний риск
        while(true) {
            if (sum.remainder(divideBy).compareTo(zero)!=0) {
                sum = sum.subtract(sub);
                ost = ost.add(sub);
            } else {
                BigDecimal sumRisk = sum.divide(countRisks);
                for(int i= 0;i<= risks.size()-2;i++){
                  risks.get(i).useSum(sumRisk);
                }
                risks.get(risks.size() - 1).useSum(sumRisk.add(ost));
                break;
            }
        }
    }
}

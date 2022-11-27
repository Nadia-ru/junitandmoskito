package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * интерфейс распредления рисков
 */
public interface IDistributionRisks {
    void sendSum(BigDecimal sum, List<Risk> risks);
}

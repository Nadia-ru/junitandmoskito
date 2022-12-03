package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * интерфейс распредления рисков
 */
public interface RiskSummator {
    void sendSum(BigDecimal sum, List<RiskCompositor> risks);
}

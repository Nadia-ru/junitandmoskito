package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;

/**
 * интерфейс риска в договоре
 */
public interface RiskCompositor {
    void useSum(BigDecimal newSum);
}

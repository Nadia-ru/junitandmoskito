package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * интерфейс риска в договоре
 */
public interface IRisk {
    void useSum(BigDecimal newSum);
}

package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;

/**
 * ��������� ����� � ��������
 */
public interface RiskCompositor {
    void useSum(BigDecimal newSum);
}

package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * ��������� ������������ ������
 */
public interface RiskSummator {
    void sendSum(BigDecimal sum, List<RiskCompositor> risks);
}

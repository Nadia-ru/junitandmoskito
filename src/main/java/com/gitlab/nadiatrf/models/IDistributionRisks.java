package com.gitlab.nadiatrf.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * ��������� ������������ ������
 */
public interface IDistributionRisks {
    void sendSum(BigDecimal sum, List<Risk> risks);
}

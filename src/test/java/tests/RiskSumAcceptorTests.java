package tests;

import com.gitlab.nadiatrf.models.RiskSumAcceptor;
import com.gitlab.nadiatrf.models.RiskSummator;
import com.gitlab.nadiatrf.models.RiskCompositor;
import com.gitlab.nadiatrf.models.Risk;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RiskSumAcceptorTests {
    RiskSummator distributionRisks;

    @Before
    public void init(){
        distributionRisks= new RiskSumAcceptor();
    }
    @Test
    public void  riskSumMatch(){
        RiskCompositor risk1 = mock(RiskCompositor.class);
        RiskCompositor risk2 = mock(RiskCompositor.class);

        distributionRisks.sendSum(BigDecimal.valueOf(200), Arrays.asList(risk1,risk2));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(10000,2));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(10000,2));
    }


    @Test
    public void  allSumMatchWithOddNumberParameters(){
        RiskCompositor risk1 = mock(RiskCompositor.class);
        RiskCompositor risk2 = mock(RiskCompositor.class);
        RiskCompositor risk3 = mock(RiskCompositor.class);

       distributionRisks.sendSum(BigDecimal.valueOf(100), Arrays.asList(risk1,risk2, risk3));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk3,times(1)).useSum(BigDecimal.valueOf(33.34));
    }

    // тест на случай если перевес риска больше, чем 1 копейка
    @Test
    public void  allSumMatchWithFourParameters(){
        RiskCompositor risk1 = mock(RiskCompositor.class);
        RiskCompositor risk2 = mock(RiskCompositor.class);
        RiskCompositor risk3 = mock(RiskCompositor.class);
        RiskCompositor risk4 = mock(RiskCompositor.class);


        distributionRisks.sendSum(BigDecimal.valueOf(1137.43), Arrays.asList(risk1,risk2, risk3,risk4));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(284.35));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(284.35));
        verify(risk3,times(1)).useSum(BigDecimal.valueOf(284.35));
        verify(risk4,times(1)).useSum(BigDecimal.valueOf(284.38));

    }
}

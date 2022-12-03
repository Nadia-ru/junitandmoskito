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

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(100));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(100));
    }


    @Test
    public void  allSumMatchWithOddNumberParameters(){
        RiskCompositor risk1 = mock(Risk.class);
        RiskCompositor risk2 = mock(Risk.class);
        RiskCompositor risk3 = mock(Risk.class);

       distributionRisks.sendSum(BigDecimal.valueOf(100), Arrays.asList(risk1,risk2, risk3));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(33.34));
    }
}

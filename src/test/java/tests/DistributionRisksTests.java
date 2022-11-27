package tests;

import com.gitlab.nadiatrf.models.DistributionRisks;
import com.gitlab.nadiatrf.models.IDistributionRisks;
import com.gitlab.nadiatrf.models.IRisk;
import com.gitlab.nadiatrf.models.Risk;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DistributionRisksTests {
    IDistributionRisks distributionRisks;

    @Before
    public void init(){
        distributionRisks= new DistributionRisks();
    }
    @Test
    public void  riskSumMatch(){
        IRisk risk1 = mock(IRisk.class);
        IRisk risk2 = mock(IRisk.class);

        distributionRisks.sendSum(BigDecimal.valueOf(200), Arrays.asList(risk1,risk2));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(100));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(100));
    }


    @Test
    public void  allSumMatchWithOddNumberParameters(){
        IRisk risk1 = mock(Risk.class);
        IRisk risk2 = mock(Risk.class);
        IRisk risk3 = mock(Risk.class);

       distributionRisks.sendSum(BigDecimal.valueOf(100), Arrays.asList(risk1,risk2, risk3));

        verify(risk1,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(33.33));
        verify(risk2,times(1)).useSum(BigDecimal.valueOf(33.34));
    }
}

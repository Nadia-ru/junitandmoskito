package tests;

import com.gitlab.nadiatrf.models.IRisk;
import com.gitlab.nadiatrf.models.Risk;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RiskTests {
    @Mock
    IRisk risk;

    // проверяет равномерно ли распределилилсь риски по общей сумме страховки
    @Test
    public void testUseSum() {
        Integer sum = 16000;
        assertEquals("the risks do not match the distribution",
                Arrays.asList(new Risk(4000), new Risk(4000), new Risk(4000), new Risk(4000)),
                risk.useSum(sum));
    }

    @Test
    public void testUseSumWhereSumIsZero() {
        Mockito.doThrow(new RuntimeException()).when(risk).useSum(0);

        risk.useSum(0);
    }

    @Test
    public void testUseSumWhereNegativeSum() {
        Mockito.doThrow(new RuntimeException()).when(risk).useSum(-1);

        risk.useSum(-1);
    }
}

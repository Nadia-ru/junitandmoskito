package tests;

import com.gitlab.nadiatrf.models.ContractAmount;
import com.gitlab.nadiatrf.models.Risk;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class ContractAmountTests {

    // проверяет равномерно ли распределилилсь риски по общей сумме страховки
    @Test
    public void testUseSum(){
        ContractAmount contractAmount = new ContractAmount(16000, Arrays.asList("от кражи", "от смерти в результате болезни", "от болезни(восполнить расходы на лечение)", "от смерти в результате несчастного случая"));
        assertEquals("the risks do not match the distribution",
                Arrays.asList(new Risk(4000),new Risk(4000),new Risk(4000),new Risk(4000)),
                contractAmount.getRisks());
    }

    @Test
    public void verificationTest(){
        ContractAmount contractAmount =Mockito.mock(ContractAmount.class);
        verify(contractAmount).useSum(contractAmount.getAmount(),contractAmount.getRiskList());
    }
}

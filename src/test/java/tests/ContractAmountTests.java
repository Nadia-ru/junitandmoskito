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

    @Test
    public void testUseSum(){
        ContractAmount contractAmount = new ContractAmount(16000, Arrays.asList("�� �����", "�� ������ � ���������� �������", "�� �������(���������� ������� �� �������)", "�� ������ � ���������� ����������� ������"));
        assertEquals("risks fit the distribution",
                Arrays.asList(new Risk(4000),new Risk(4000),new Risk(4000),new Risk(4000)),
                contractAmount.getRisks());
    }

    @Test
    public void verificationTest(){
        ContractAmount contractAmount =Mockito.mock(ContractAmount.class);
        verify(contractAmount).useSum(contractAmount.getAmount(),contractAmount.getRiskList());
    }
}

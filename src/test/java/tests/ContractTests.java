package tests;

import com.gitlab.nadiatrf.models.Contract;
import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ContractTests {
    private Contract contract;

    public ContractTests(Contract contract) {
        this.contract = contract;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new Contract("n+m*0.1", Arrays.asList(30000, 20))},
                {new Contract("n%m/c+1", Arrays.asList(100, 10, 10))},
                {new Contract("n%m", Arrays.asList(100, 10, 10))},
                {new Contract("n-5m/c", Arrays.asList(100, 10))},
                {new Contract("n-m+34.0", Arrays.asList(100, 10))},
                {new Contract("n-n+34.0", Arrays.asList(100, 10))},
        });
    }


    @Test
    @Ignore
    public void createContract() {
        Contract contract = Mockito.mock(Contract.class);
        assertEquals(null, contract.getFormula());
    }

    @Test
    public void testChecked() {
        System.out.println("formula: " + contract.getFormula());
        System.out.println("options: " + contract.getOptions());
    }

    //проверка на некоректные операции
    @Test
    public void invalidOperations() {
        Pattern pattern = Pattern.compile("(%|//|<|>|=)+");
        Matcher matcher = pattern.matcher(contract.getFormula());
        Boolean isInvalid = matcher.find();
        assertFalse("invalid operation in formula", isInvalid);
    }

    //проверка на соотвтетсвующее колличество параметров в формуле
    @Test
    public void missingParameters() {
        int countParameters = contract.getOptions().size();
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(contract.getFormula());
        HashSet<String> parameters = new HashSet<String>();
        while(matcher.find())
            parameters.add(matcher.group());
        Boolean isInvalid = false;
        int countParamInFormula = parameters.size();
        String err="extra parameters in the formula";
        if(countParameters>countParamInFormula) {
            isInvalid = true;
            err = "formula is missing parameters";
        } else if (countParameters < countParamInFormula) {
            isInvalid = true;
        }
        assertFalse(err, isInvalid);
    }

    @Test
    public void correctOdds(){
        // шаблон для проверки неккоректных величин коээффициентов в формуле (просто чисел или неверных дробей)
        Pattern pattern = Pattern.compile("([+-]?((\\d+\\.{1}\\d*)|(\\.\\d+)))|(^[\\W\\sa-zA-Z_-]+$)");
        Matcher matcher = pattern.matcher(contract.getFormula());
        Boolean isInvalid = matcher.find();
        assertTrue("incorrect coefficient in the formula", isInvalid);
    }
}

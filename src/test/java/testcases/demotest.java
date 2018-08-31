package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import scenarios.FetchNumbersScenarios;

public class demotest {

    @Test
    public void test1(ITestContext context) {
        FetchNumbersScenarios fetchNumbersScenarios = new FetchNumbersScenarios(context);
        fetchNumbersScenarios.run();
    }
}

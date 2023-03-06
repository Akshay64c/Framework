package api.CucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/api/CucumberTest", glue = "api.StepDefinition")
public class TestRunner extends AbstractTestNGCucumberTests {
}

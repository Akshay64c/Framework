package StepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber/Tests/CreateProduct.feature",glue="StepDefinition",
plugin = {"pretty","html:target/cucumber-reports/report.html"}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}

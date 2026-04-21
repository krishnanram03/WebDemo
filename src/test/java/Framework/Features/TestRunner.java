package Framework.Features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Framework/Features",glue="Framework.StepDefinitions",monochrome=true,plugin= {"html:reports/cucumber-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}

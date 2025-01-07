package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"Features"}, 
    glue = {"StepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html", "json:target/cucumber-reports/cucumber-reports.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    tags="@regression",
    monochrome = true
)

public class Runnerfile extends AbstractTestNGCucumberTests{

}
package hu.nye.uni;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "hu.nye.uni.stepdefs",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

)
public class TestRunnerIT {
}
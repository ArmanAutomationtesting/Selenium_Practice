import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\resources\\FacebookLoginFeature.feature",
        glue = "StepDifinition",
        plugin = {
                "pretty",                                   // Console output in a readable format
                "html:target/cucumber-reports.html",       // HTML report
                "json:target/cucumber.json",               // JSON report
                "junit:target/cucumber.xml"                // JUnit XML report
        },
        monochrome = true,
        tags = "@Simple"
)

public class TestRunner {
}

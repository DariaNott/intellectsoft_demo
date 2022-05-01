package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Runner class is an entry point for cucumber in java.
 * It contains the most important and basic settings. This file may answer different questions:
 * - where I can find test scenarios?
 * - where I can find step definitions?
 * - which scenarios will be executed?
 * - where I can find reports?
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        //if publish set to true - your report will be posted on https://reports.cucumber.io/ - pretty juicy feature!
        //report will be self destroyed in 24 hours by default, you don't want to use this feature - use plugins
        publish = true,
        //glue is everything that cucumber actually working with
        glue = {
                "com.intellectsoft.cucumber.step", //step definitions
                "com.intellectsoft.cucumber.hook", //hooks (before and after scenarios functions)
                //plugins - some custom extensions for your test framework (your own written plugins)
        },
        features = "src/test/java/com/intellectsoft/features", //folder with your scenarios, it should contain files with .feature extension
        tags = "@debug", //tags - are marks that is written before scenarios, you can select different scenarios to run using tags
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "pretty"} // cucumber built-in plugins (mainly reporters)
)
public class RunnerTest {
    //just empty class, nothing more required here
}

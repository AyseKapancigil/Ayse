package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import static base_url_setup.FondyBaseUrl.fondySetup;

public class Hooks {

    @Before(value ="@url")
    public void before_url(){ fondySetup();

    }

    public void tearDown(Scenario scenario) {
        System.out.println("After Hooks");
        //Adding Reports that is generated when a scenario fails.
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_scenario");
            Driver.getDriver().quit();

            //main functionality is creating better report
        }
    }
}
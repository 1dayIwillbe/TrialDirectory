package com.takealot;

import com.cucumber.listener.Reporter;
import com.takealot.utilities.PropertyReader;
import com.takealot.utilities.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase extends Utility {
    @Before
    public void setUP() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Jig");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
           Utility.takeScreenShot();
           browserDown();
        }
       browserDown();
    }
}

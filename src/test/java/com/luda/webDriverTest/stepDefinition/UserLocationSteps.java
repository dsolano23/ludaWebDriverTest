package com.luda.webDriverTest.stepDefinition;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.utilsType.WebSelector;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLocationSteps {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserLocationSteps.class);
    @When("^I insert a user location address: (.+)$")
    public void i_insert_a_user_location_address(String userLocationAddress) throws Throwable {
        LOGGER.debug("I insert a user location address:" + userLocationAddress);
        WebElement insertEmail = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId("insertSearchLocationField.id")));
        insertEmail.clear();
        insertEmail.sendKeys(userLocationAddress);
    }
}

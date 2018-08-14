package com.luda.webDriverTest.stepDefinition.booking;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.BookingPanelKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingValidations {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookingValidations.class);

    @Then("^the booking panel will be shown to me$")
    public void the_booking_panel_will_be_shown_to_me() throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.bookingPanel.name();
        String classAttribute = ElementAttributeKeys.classAtr.name();

        WebElement bookingPanel  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable((WebSelector.getElementAttribute(keyWebComponent, keyWebElement))));
        LOGGER.debug("value of slide-in " + bookingPanel.getAttribute(classAttribute));
        Assert.assertEquals(true, bookingPanel.getAttribute(classAttribute).equalsIgnoreCase(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, classAttribute)));
    }

    @Then("^the list of found items is shown$")
    public void the_list_of_found_items_is_shown() throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.itemsTable.name();

        WebElement itemsTable  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable((WebSelector.getElementAttribute(keyWebComponent, keyWebElement))));
        itemsTable.isDisplayed();
    }

    @Then("^the popup of element added to the cart is shown$")
    public void the_popup_of_element_added_to_the_cart_is_shown() throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.addItemToCartPopup.name();

        WebElement itemsTable  =  Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated((WebSelector.getElementAttribute(keyWebComponent, keyWebElement))));
        itemsTable.isDisplayed();
    }
}

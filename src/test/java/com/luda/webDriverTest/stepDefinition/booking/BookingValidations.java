package com.luda.webDriverTest.stepDefinition.booking;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.pom.BookingPagePOM;
import com.luda.webDriverTest.pom.CartPagePOM;
import com.luda.webDriverTest.pom.EndBookingPagePOM;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.BookingPanelKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingValidations {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookingValidations.class);
    BookingPagePOM bookingPage;
    CartPagePOM cartPagePOM;
    EndBookingPagePOM endBookingPagePOM;

    @Then("^The user location address for the booking is: (.+)$")
    public void the_user_location_address_for_the_booking_is(String userAddress) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        String resultReceived;
        String resultExpected;
        if ( userAddress.equalsIgnoreCase("defaultValue")){
            String keyWebComponent =  WebComponentKeys.bookingPanel.name();
            String insertLocationUserKey = BookingPanelKeys.insertLocationUser.name();
            String placeholder = ElementAttributeKeys.placeholder.name();
            resultExpected = WebSelector.getElementAttribute(keyWebComponent,insertLocationUserKey,placeholder);
            resultReceived = bookingPage.getLocationUserPlaceholder();
        }else{
            resultExpected = userAddress;
            resultReceived = bookingPage.getLocationUser();
        }
        String assertTrace = " The user location address for the booking is - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^The booking panel (.+) be shown to me$")
    public void the_booking_panel_be_shown_to_me(String will)   throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        Boolean resultReceived = bookingPage.bookingPanelIsDisplayed();
        Boolean resultExpected = null;

        if ( will.equalsIgnoreCase("will")){
            resultExpected = true;

        }else if ( will.equalsIgnoreCase("not will")){
            resultExpected = false;
        }
        String assertTrace = " The list of found items " + will + " shown in the booking panel - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }
    @Then("^The button continue with the booking (.+) available$")
    public void the_button_continue_with_the_booking_available(String be) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        Boolean resultReceived = bookingPage.continueButtonIsEnabled();
        Boolean resultExpected = null;

        if ( be.equalsIgnoreCase("is")){
            resultExpected = true;

        }else if ( be.equalsIgnoreCase("is not")){
            resultExpected = false;
        }

        String assertTrace = " The button continue with the booking " + be + " available: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^The list of found items (.+) shown in the booking panel$")
    public void the_list_of_found_items_shown_in_the_booking_panel(String be) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());

        Boolean resultReceived = bookingPage.itemsTableIsDisplayed();
        Boolean resultExpected = null;

        if ( be.equalsIgnoreCase("is")){
            resultExpected = true;

        }else if ( be.equalsIgnoreCase("is not")){
            resultExpected = false;
        }

        String assertTrace = " The list of found items " + be + " shown in the booking panel - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^My cart have (.+) items added$")
    public void my_cart_have_items_added(String itemsCount) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        if (itemsCount.equalsIgnoreCase("0")){
            itemsCount ="";
        }
        String resultReceived = bookingPage.getItemsInTheCart().toLowerCase();
        String resultExpected = itemsCount.toLowerCase();
        String assertTrace = " Bad items added in the cart  Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @And("^The cart panel (.+) available$")
    public void the_cart_panel_available(String be) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        Boolean resultReceived = cartPagePOM.isShowing();
        Boolean resultExpected = null;

        if ( be.equalsIgnoreCase("is")){
            resultExpected = true;

        }else if ( be.equalsIgnoreCase("is not")){
            resultExpected = false;
        }

        String assertTrace = " The cart panel " + be + " available: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^the popup of element added to the cart is shown$")
    public void the_popup_of_element_added_to_the_cart_is_shown() throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.addItemToCartPopup.name();

        WebElement itemsTable  =  Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated((WebSelector.getElementAttribute(keyWebComponent, keyWebElement))));
        itemsTable.isDisplayed();
    }

    @Then("^The (.+) item (.+) in the cart$")
    public void the_item_in_the_cart(String itemDescription, String be) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        cartPagePOM.cartShow();
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        Boolean resultReceived = cartPagePOM.isItemInCart(itemsResultSearch,itemDescription);
        Boolean resultExpected = null;
        if ( be.equalsIgnoreCase("is")){
            resultExpected = true;

        }else if ( be.equalsIgnoreCase("is not")){
            resultExpected = false;
        }
        String assertTrace = " The " + itemDescription + " item " + be + " in the cart resultReceived:" + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^I have a total of (\\d+) (.+) items in my cart$")
    public void i_have_a_total_of_items_in_my_reserve(int totalItems, String itemDescription) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        cartPagePOM.cartShow();
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        int resultReceived;
        if (cartPagePOM.isItemInCart(itemsResultSearch,itemDescription)){
            resultReceived = cartPagePOM.totalItemInTheCart(itemsResultSearch,itemDescription);
        }else{
            resultReceived = 0;
        }

        int resultExpected = totalItems;
        String assertTrace = " I have a total of " + totalItems + " " + itemDescription + " items in my cart - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }


    @Then("^The endBooking panel (.+) be shown to me$")
    public void the_endbooking_panel_be_shown_to_me(String will) throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        Boolean resultReceived = endBookingPagePOM.endBookingPanelIsDisplayed();
        Boolean resultExpected = null;
        if ( will.equalsIgnoreCase("will")){
            resultExpected = true;

        }else if ( will.equalsIgnoreCase("will not")){
            resultExpected = false;
        }
        String assertTrace = " The endBooking panel " + will + " be shown to me - resultReceived:" + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^I have a total of (\\d+) (.+) items in the endBooking panel$")
    public void i_have_a_total_of_item_in_the_endBooking_panel(int totalItems, String itemDescription) throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = endBookingPagePOM.getItemsInTable();
        int resultReceived = endBookingPagePOM.totalItemInEndBooking(itemsResultSearch,itemDescription);
        int resultExpected = totalItems;
        String assertTrace = " I have a total of " + totalItems + " " + itemDescription + " items in the endBooking panel - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^(.+) is the default pharmacy selected in the endBooking panel$")
    public void is_the_default_pharmacy_selected_in_the_endbooking_panel(String pharmacyName) throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = endBookingPagePOM.getPharmacyTable();
        Boolean resultReceived = endBookingPagePOM.isPharmacySelected(itemsResultSearch, pharmacyName);
        Boolean resultExpected = true;
        String assertTrace = pharmacyName + " is the default pharmacy selected in the endBooking panel - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }
}

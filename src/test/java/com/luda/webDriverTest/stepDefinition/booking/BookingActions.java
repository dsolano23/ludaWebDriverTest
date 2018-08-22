package com.luda.webDriverTest.stepDefinition.booking;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.pom.BookingPagePOM;
import com.luda.webDriverTest.pom.CartPagePOM;
import com.luda.webDriverTest.pom.EndBookingPagePOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BookingActions {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookingActions.class);
    BookingPagePOM bookingPage;
    EndBookingPagePOM endBookingPagePOM;
    CartPagePOM cartPagePOM;

    @When("^I insert a user location address: (.+)$")
    public void i_insert_a_user_location_address(String userLocationAddress) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        TimeUnit.SECONDS.sleep(3);
        bookingPage.setLocationUser(userLocationAddress);
        TimeUnit.SECONDS.sleep(1);
        bookingPage.selectAutoCompLocationResult(1);
        TimeUnit.SECONDS.sleep(1);
    }

    @When("^I find the item with the description (.+)$")
    public void i_find_the_item_with_the_description(String itemDescription) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        bookingPage.setItemToSearch(itemDescription);
        TimeUnit.SECONDS.sleep(1);
        bookingPage.searchItem();
        TimeUnit.SECONDS.sleep(3);
    }

    @When("^I put the item (.+) to the cart$")
    public void i_put_the_item_to_the_cart(String itemDescription) throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = bookingPage.getItemsTableResult();
        bookingPage.putItemsWhichDescriptionToCart(itemsResultSearch,itemDescription);
        TimeUnit.SECONDS.sleep(1);
    }

    @When("^I consult my current cart$")
    public void i_consult_my_current_cart() throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        if (!cartPagePOM.isShowing()){
            bookingPage = new BookingPagePOM(Hooks.getWebDriver());
            bookingPage.cartButtonClick();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @When("^I hide my current cart$")
    public void i_hide_my_current_cart() throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        if (cartPagePOM.isShowing()){
            bookingPage = new BookingPagePOM(Hooks.getWebDriver());
            bookingPage.cartButtonClick();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @And("^I add (\\d+) items of (.+) in the booking$")
    public void i_add_items_of_in_the_booking(int addMore, String itemDescription) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        cartPagePOM.addMoreCurrentItems(itemsResultSearch,itemDescription.trim(),addMore);
        TimeUnit.SECONDS.sleep(1);
    }

    @And("^I rest (\\d+) items of (.+) in the booking$")
    public void i_rest_items_of_in_the_booking(int restNum, String itemDescription) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        cartPagePOM.restCurrentItems(itemsResultSearch,itemDescription.trim(),restNum);
        TimeUnit.SECONDS.sleep(1);
    }

    @And("^I remove the (.+) item from the booking$")
    public void i_remove_the_item_from_the_booking(String itemDescription) throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        TimeUnit.SECONDS.sleep(1);
        cartPagePOM.removeItemOfCart(itemsResultSearch, itemDescription.trim());
        TimeUnit.SECONDS.sleep(1);
    }

    @When("^I remove all items of the booking$")
    public void i_remove_all_items_of_the_booking() throws Throwable {
        cartPagePOM = new CartPagePOM(Hooks.getWebDriver());
        WebElement itemsResultSearch = cartPagePOM.getItemsInCart();
        TimeUnit.SECONDS.sleep(1);
        cartPagePOM.removeAllItemOfCart(itemsResultSearch);
    }

    @When("^I go to end my booking$")
    public void i_go_to_end_my_booking() throws Throwable {
        bookingPage = new BookingPagePOM(Hooks.getWebDriver());
        bookingPage.continueButtonClick();
        TimeUnit.SECONDS.sleep(1);
    }

    @When("^I select the change pharmacy option in the endBooking panel$")
    public void i_select_the_change_pharmacy_option_in_the_endBooking_panel() throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        endBookingPagePOM.changePharmacy();
        TimeUnit.SECONDS.sleep(1);
    }

    @When("^I select the come back option in the endBooking panel$")
    public void i_select_the_come_back_option_in_the_endbooking_panel() throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        endBookingPagePOM.comeBack();
        TimeUnit.SECONDS.sleep(3);
    }

    @When("^I select the new booking option in the endBooking panel$")
    public void i_select_the_new_booking_option_in_the_endbooking_panel() throws Throwable {
        endBookingPagePOM = new EndBookingPagePOM(Hooks.getWebDriver());
        endBookingPagePOM.newBooking();
        TimeUnit.SECONDS.sleep(3);
    }

}

package com.luda.webDriverTest.stepDefinition.login;

import com.luda.webDriverTest.beans.ElementDTO;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.pom.CreateUserPagePOM;
import com.luda.webDriverTest.pom.LoginPagePOM;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.LoginFormKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;


public class LoginValidations {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginValidations.class);
    LoginPagePOM loginPage;
    CreateUserPagePOM createUserPage;

    @Then("^The create user button (.+) available$")
    public void the_create_user_button_available(String be) throws Throwable {
        createUserPage = new CreateUserPagePOM(Hooks.getWebDriver());
        Boolean resultReceived = createUserPage.saveButtonIsDisplayed();
        Boolean resultExpected = null;

        if ( be.equalsIgnoreCase("is")){
            resultExpected = true;

        }else if ( be.equalsIgnoreCase("is not")){
            resultExpected = false;
        }

        String assertTrace = " The create user button " + be + " available: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

    }

    @Then("^The look and feel of the page Create User is correct$")
    public void the_look_and_feel_of_the_page_create_user_is_correct() throws Throwable {
        createUserPage = new CreateUserPagePOM(Hooks.getWebDriver());
        createUserPage.loadPlaceholderWebElements();
        Hashtable<String, ElementDTO> virtualWebElementsAtrList =  createUserPage.getWebElementsList();
        WebElement virtualWebElement;
        ElementDTO virtualWebElementArt;
        By virtualElementId;
        String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
        String keyWebComponent = WebComponentKeys.createFinalUserForm.name();
        String attribute = ElementAttributeKeys.placeholder.name();
        String resultReceived;
        String resultExpected;
        String assertTrace;

        for (String key : virtualWebElementsAtrList.keySet()) {
            if (virtualWebElementsAtrList.get(key).getType().equalsIgnoreCase(txtBoxTypeElement)){
                virtualWebElementArt = virtualWebElementsAtrList.get(key);
                virtualElementId = virtualWebElementArt.getIdElement();
                virtualWebElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(virtualElementId));
                resultReceived = virtualWebElement.getAttribute(attribute);
                resultExpected = WebSelector.getElementAttribute(keyWebComponent, virtualWebElementArt.getElementKey(), attribute );
                assertTrace = " Bad Placeholder for " + virtualWebElementArt.getElementKey() + " - Received: " + resultReceived +" & Expected: " + resultExpected;
                Assert.assertEquals(assertTrace, resultExpected, resultReceived);
            }
        }
    }

    @Then("^Message displayed Login Successfully for the user (.+)$")
    public void message_displayed_login_successfully_for_the_user(String userName) throws Throwable {
        loginPage = new LoginPagePOM(Hooks.getWebDriver());

        String resultReceived = loginPage.getLogInSuccessfullyMessage().toLowerCase();
        String resultExpected = userName.toLowerCase();
        String assertTrace = " Bad Message LogInSuccessfully  Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
    }

    @Then("^Message displayed Login unsuccessfully$")
    public void message_displayed_login_unsuccessfully() throws Throwable {
        loginPage = new LoginPagePOM(Hooks.getWebDriver());

        String assertTrace = " Message displayed Login unsuccessfully: ";
        Assert.assertEquals(assertTrace,true, loginPage.logInUnsuccessfullyIsDisplayed());

        String resultReceived = loginPage.getLogInUnsuccessfullyMessage();
        String keyWebComponent = WebComponentKeys.loginForm.name();
        String keyWebElement = LoginFormKeys.UnsuccessfullyLabel.name();
        String attribute = ElementAttributeKeys.text.name();
        String resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Message LogInUnsuccessfully  Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

    }

}


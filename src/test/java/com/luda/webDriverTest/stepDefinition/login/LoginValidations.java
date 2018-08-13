package com.luda.webDriverTest.stepDefinition.login;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.pom.CreateUserPagePOM;
import com.luda.webDriverTest.pom.LoginPagePOM;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.CreateFinalUserFromKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.LoginFormKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        String keyWebComponent = WebComponentKeys.createFinalUserForm.name();
        String keyWebElement = CreateFinalUserFromKeys.InsertIdUser.name();
        String attribute = ElementAttributeKeys.placeholder.name();

        String resultReceived = createUserPage.getIdUserPlaceholder();
        String resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        String assertTrace = " Bad Placeholder for txtbxIdUser - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getEmailPlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertEmail.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxEmail - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getPasswordPlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertPassword.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxPassword - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getConfirmPasswordPlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertConfirmPassword.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxConfirmPassword - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getUserNamePlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertUserName.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxUserName - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getUserNamePlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertUserName.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxUserName - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getUserSurnamePlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertUserSurname.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxUserSurname - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getUserAgePlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertAge.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxUserAge - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getUserPhonePlaceholder();
        keyWebElement = CreateFinalUserFromKeys.InsertPhone.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Placeholder for txtbxUserPhone - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);

        resultReceived = createUserPage.getSaveButtonText();
        keyWebElement = CreateFinalUserFromKeys.SaveButton.name();
        attribute = ElementAttributeKeys.text.name();
        resultExpected = WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute );
        assertTrace = " Bad Text for SaveButton - Received: " + resultReceived +" & Expected: " + resultExpected;
        Assert.assertEquals(assertTrace, resultExpected, resultReceived);
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


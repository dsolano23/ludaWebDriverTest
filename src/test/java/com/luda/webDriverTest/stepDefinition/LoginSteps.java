package com.luda.webDriverTest.stepDefinition;

import com.luda.webDriverTest.enviroment.EnviromentConstantsNames;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.utilsType.FileWriter;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.KeyWebElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class LoginSteps {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginSteps.class);


    
    @Given("^User Navigate to Home Page$")
    public void user_navigate_to_Home_Page() throws Throwable {
    	LOGGER.debug("User is on Home Page - " + FileWriter.getEnvProps().getProperty(EnviromentConstantsNames.MAIN_URL));
        Hooks.getWebDriver().manage().deleteAllCookies();
        Hooks.getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Hooks.getWebDriver().navigate().to(FileWriter.getEnvProps().getProperty(EnviromentConstantsNames.MAIN_URL));
        Hooks.getWebDriver().navigate().refresh();
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
    }


/*    @When("^I look for the field(.+) the placeholder is (.+)$")
    public void verifyUserPlaceholder(String field, String value)throws Throwable {
        WebElement insertEmail = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElement("selector.userField")));
    }
*/

    @When("^I tried to login with (.+) and (.+)$")
    public void i_tried_to_login_with_and(String userName, String password) throws Throwable {

        String keyWebElement = KeyWebElements.loginInsertNameField.name();
        WebElement insertNameField = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertNameField.getAttribute("placeholder").toLowerCase());
        insertNameField.clear();
        insertNameField.sendKeys(userName);

        keyWebElement = KeyWebElements.loginInsertPasswordFiel.name();
        WebElement insertPasswordField = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        //Assert.assertEquals(WebSelector.getWebElementText(keyWebElement).toLowerCase(), insertPassword.getTagName().toLowerCase());
        //Assert.assertEquals(WebSelector.getWebElementText(keyWebElement).toLowerCase(), insertPassword.getText().toLowerCase());
        //Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertPassword.getAttribute("placeholder").toLowerCase());
        insertPasswordField.clear();
        insertPasswordField.sendKeys(password);

        keyWebElement = KeyWebElements.loginSumitButton.name();
        WebElement sumitButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementText(keyWebElement).toLowerCase(), sumitButton.getText().toLowerCase());
        sumitButton.click();

    }

    @Given("^User Navigate to CreateFinalUser Page$")
    public void user_navigate_to_createfinaluser_page() throws Throwable {
        LOGGER.debug("el valor de KeyWebElements.loginAccestToCreateUser.name() es: " + KeyWebElements.loginAccestToCreateUser.name());
        WebElement accestToCreateUser = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(KeyWebElements.loginAccestToCreateUser.name())));
        accestToCreateUser.click();
    }

    @When("^I filled the form with the data idUsername: (.+), email: (.+), password: (.+), confirmPWD: (.+), name: (.+), surname: (.+), age: (.+), phone: (.+)$")
    public void i_filled_the_form_with_the_data_idusername_email_password_confirmpwd_name_surname_age_phone(String iduserName, String email, String password, String confirmPWD, String name, String surname, String age, String phone) throws Throwable {
        String keyWebElement = KeyWebElements.createFinalInsertIdUser.name();
        WebElement insertIdUserField = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertIdUserField.getAttribute("placeholder").toLowerCase());
        insertIdUserField.clear();
        insertIdUserField.sendKeys(iduserName);

        keyWebElement = KeyWebElements.createFinalInsertEmail.name();
        WebElement insertEmail = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertEmail.getAttribute("placeholder").toLowerCase());
        insertEmail.clear();
        insertEmail.sendKeys(email);

        keyWebElement = KeyWebElements.createFinalInsertPassword.name();
        WebElement insertPassword = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertPassword.getAttribute("placeholder").toLowerCase());
        insertPassword.clear();
        insertPassword.sendKeys(password);

        keyWebElement = KeyWebElements.createFinalInsertConfirmPassword.name();
        WebElement insertConfirmpwd = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertConfirmpwd.getAttribute("placeholder").toLowerCase());
        insertConfirmpwd.clear();
        insertConfirmpwd.sendKeys(confirmPWD);

        keyWebElement = KeyWebElements.createFinalInsertUserName.name();
        WebElement insertName = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertName.getAttribute("placeholder").toLowerCase());
        insertName.clear();
        insertName.sendKeys(name);

        keyWebElement = KeyWebElements.createFinalInsertUserSurame.name();
        WebElement insertSurname = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertSurname.getAttribute("placeholder").toLowerCase());
        insertSurname.clear();
        insertSurname.sendKeys(surname);

        keyWebElement = KeyWebElements.createFinalInsertAge.name();
        WebElement insertAge = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertAge.getAttribute("placeholder").toLowerCase());
        insertAge.clear();
        insertAge.sendKeys(age);

        keyWebElement = KeyWebElements.createFinalInsertPhone.name();
        WebElement insertPhone = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(keyWebElement)));
        Assert.assertEquals(WebSelector.getWebElementPlaceholder(keyWebElement).toLowerCase(), insertPhone.getAttribute("placeholder").toLowerCase());
        insertPhone.clear();
        insertPhone.sendKeys(phone);
    }


    @Then("^The create user button (.+) available$")
    public void the_create_user_button_available(String be) throws Throwable {
        WebElement saveButton  = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(KeyWebElements.createFinalSaveButton.name())));
        if ( be.equalsIgnoreCase("is")){
            Assert.assertEquals(true, saveButton.isEnabled());
        }else if ( be.equalsIgnoreCase("is not")){
            Assert.assertEquals(true, !saveButton.isEnabled());
        }
    }

    @Then("^Message displayed Login Successfully for the user (.+)$")
    public void message_displayed_login_successfully_for_the_user(String userName) throws Throwable {
        WebElement idUserNameSession = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(KeyWebElements.loginIdUserNameSessionLabel.name())));

        Assert.assertEquals(true, idUserNameSession.isDisplayed());
        Assert.assertEquals(true , idUserNameSession.getText().equalsIgnoreCase(userName));

        LOGGER.info("Unlogin Successfully");
    }

    @Then("^Message displayed Login unsuccessfully$")
    public void message_displayed_login_unsuccessfully() throws Throwable {

        WebElement loginUnsuccessfully = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getWebElementId(KeyWebElements.loginUnsuccessfullyLabel.name())));
        Assert.assertEquals(true, loginUnsuccessfully.isDisplayed());
        Assert.assertEquals(WebSelector.getWebElementText(KeyWebElements.loginUnsuccessfullyLabel.name()).toLowerCase(), loginUnsuccessfully.getText().toLowerCase());

    }


}


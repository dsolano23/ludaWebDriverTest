package com.luda.webDriverTest.stepDefinition.login;

import com.luda.webDriverTest.enviroment.EnviromentConstantsNames;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.pom.CreateUserPagePOM;
import com.luda.webDriverTest.pom.LoginPagePOM;
import com.luda.webDriverTest.utilsType.FileWriter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class LoginActions {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginActions.class);
    LoginPagePOM loginPage;
    CreateUserPagePOM createUserPage;

    
    @Given("^User Navigate to Home Page$")
    public void user_navigate_to_Home_Page() throws Throwable {
    	LOGGER.debug("User is on Home Page - " + FileWriter.getEnvProps().getProperty(EnviromentConstantsNames.MAIN_URL));
        Hooks.getWebDriver().navigate().to(FileWriter.getEnvProps().getProperty(EnviromentConstantsNames.MAIN_URL));
        Hooks.getWebDriver().navigate().refresh();
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
    }

    @When("^I tried to login with (.+) and (.+)$")
    public void i_tried_to_login_with_and(String userName, String password) throws Throwable {
        loginPage = new LoginPagePOM(Hooks.getWebDriver());
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        Hooks.getScenario().write("User Login values userName: " + userName + " password: " + password);
        loginPage.commit();
    }


    @Given("^User Navigate to CreateFinalUser Page$")
    public void user_navigate_to_createfinaluser_page() throws Throwable {
        loginPage = new LoginPagePOM(Hooks.getWebDriver());
        loginPage.navigateToCreateUser();
    }

    @When("^I filled the form with the data idUsername: (.+), email: (.+), password: (.+), confirmPWD: (.+), name: (.+), surname: (.+), age: (.+), phone: (.+)$")
    public void i_filled_the_form_with_the_data_idusername_email_password_confirmpwd_name_surname_age_phone(String idUserName, String email, String password, String confirmPWD, String name, String surname, String age, String phone) throws Throwable {
        createUserPage = new CreateUserPagePOM(Hooks.getWebDriver());
        createUserPage.setIdUser(idUserName);
        createUserPage.setEmail(email);
        createUserPage.setPassword(password);
        createUserPage.setConfirmPassword(confirmPWD);
        createUserPage.setName(name);
        createUserPage.setSurname(surname);
        createUserPage.setAge(age);
        createUserPage.setPhone(phone);

        /*
        String keyWebComponent = WebComponentKeys.createFinalUserForm.name();
        String keyWebElement = CreateFinalUserFromKeys.InsertIdUser.name();
        String attribute = ElementAttributeKeys.placeholder.name();

        WebElement insertIdUserField = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertIdUserField.getAttribute("placeholder").toLowerCase());
        insertIdUserField.clear();
        insertIdUserField.sendKeys(idUserName);

        keyWebElement = CreateFinalUserFromKeys.InsertEmail.name();
        WebElement insertEmail = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertEmail.getAttribute("placeholder").toLowerCase());
        insertEmail.clear();
        insertEmail.sendKeys(email);

        keyWebElement = CreateFinalUserFromKeys.InsertPassword.name();
        WebElement insertPassword = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertPassword.getAttribute("placeholder").toLowerCase());
        insertPassword.clear();
        insertPassword.sendKeys(password);

        keyWebElement = CreateFinalUserFromKeys.InsertConfirmPassword.name();
        WebElement insertConfirmpwd = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertConfirmpwd.getAttribute("placeholder").toLowerCase());
        insertConfirmpwd.clear();
        insertConfirmpwd.sendKeys(confirmPWD);

        keyWebElement = CreateFinalUserFromKeys.InsertUserName.name();
        WebElement insertName = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertName.getAttribute("placeholder").toLowerCase());
        insertName.clear();
        insertName.sendKeys(name);

        keyWebElement = CreateFinalUserFromKeys.InsertUserSurname.name();
        WebElement insertSurname = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertSurname.getAttribute("placeholder").toLowerCase());
        insertSurname.clear();
        insertSurname.sendKeys(surname);

        keyWebElement = CreateFinalUserFromKeys.InsertAge.name();
        WebElement insertAge = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertAge.getAttribute("placeholder").toLowerCase());
        insertAge.clear();
        insertAge.sendKeys(age);

        keyWebElement = CreateFinalUserFromKeys.InsertPhone.name();
        WebElement insertPhone = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertPhone.getAttribute("placeholder").toLowerCase());
        insertPhone.clear();
        insertPhone.sendKeys(phone);*/
    }

}


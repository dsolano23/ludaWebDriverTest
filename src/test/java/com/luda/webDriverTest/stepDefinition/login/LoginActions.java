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
    }



}


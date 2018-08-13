package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.LoginFormKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPagePOM {


    private String keyWebComponent =  WebComponentKeys.loginForm.name();
    private String keyWebElement = "";
    private By txtbxInsertNameId = null;
    private By txtbxInsertPasswordId = null;
    private By submitButtonId = null;
    private By labelLogInUnsuccessfullyId = null;
    private By labelLogInSuccessfullyId = null;
    private By accessToCreateUserButtonId=null;

    private  WebDriver currentDriver;

    public LoginPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        keyWebElement = LoginFormKeys.InsertName.name();
        this.txtbxInsertNameId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = LoginFormKeys.InsertPassword.name();
        this.txtbxInsertPasswordId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = LoginFormKeys.SubmitButton.name();
        this.submitButtonId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = LoginFormKeys.UnsuccessfullyLabel.name();
        this.labelLogInUnsuccessfullyId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = LoginFormKeys.IdUserNameSessionLabel.name();
        this.labelLogInSuccessfullyId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = LoginFormKeys.AccessToCreateUser.name();
        this.accessToCreateUserButtonId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
    }

    public void setUserName(String userName) throws NotFoundResourceException {
        WebElement txtbxInsertName = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertNameId));
        txtbxInsertName.clear();
        txtbxInsertName.sendKeys(userName);
    }

    public void setPassword(String password) throws NotFoundResourceException {
        WebElement txtbxInsertPassword =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertPasswordId));
        txtbxInsertPassword.clear();
        txtbxInsertPassword.sendKeys(password);
    }

    public void commit() throws NotFoundResourceException {
        WebElement submitButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(submitButtonId));
        submitButton.click();
    }

    public Boolean logInUnsuccessfullyIsDisplayed() throws NotFoundResourceException{
        WebElement labelLogInUnsuccessfully =Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(labelLogInUnsuccessfullyId));
        Boolean logInUnsuccessfullyDisplayed=false;
        logInUnsuccessfullyDisplayed = labelLogInUnsuccessfully.isDisplayed();
        return logInUnsuccessfullyDisplayed;
    }

    public String getLogInUnsuccessfullyMessage() throws NotFoundResourceException{
        WebElement labelLogInUnsuccessfully =Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(labelLogInUnsuccessfullyId));
        String logInUnsuccessfullyMessage="";
        logInUnsuccessfullyMessage = labelLogInUnsuccessfully.getText();
        return logInUnsuccessfullyMessage;
    }

    public String getLogInSuccessfullyMessage() throws NotFoundResourceException{
        WebElement labelLogInSuccessfully = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(labelLogInSuccessfullyId));
        String logInSuccessfullyMessage="";
        logInSuccessfullyMessage = labelLogInSuccessfully.getText();
        return logInSuccessfullyMessage;
    }

    public void navigateToCreateUser() throws NotFoundResourceException {
        WebElement createUserButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(accessToCreateUserButtonId));
        createUserButton.click();
    }

}

package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.CreateFinalUserFromKeys;
import com.luda.webDriverTest.utilsType.constans.LoginFormKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateUserPagePOM {

    private String keyWebComponent =  WebComponentKeys.createFinalUserForm.name();
    private String keyWebElement = "";
    private By txtbxInsertIdUserId = null;
    private By txtbxInsertEmailId = null;
    private By txtbxInsertPasswordId = null;
    private By txtbxInsertConfirmPasswordId = null;
    private By txtbxInsertUserNameId = null;
    private By txtbxInsertUserSurnameId = null;
    private By txtbxInsertAgeId = null;
    private By txtbxInsertPhoneId = null;
    private By SaveButtonId=null;

    private  WebDriver currentDriver;

    public CreateUserPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        keyWebElement = CreateFinalUserFromKeys.InsertIdUser.name();
        this.txtbxInsertIdUserId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertEmail.name();
        this.txtbxInsertEmailId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertPassword.name();
        this.txtbxInsertPasswordId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertConfirmPassword.name();
        this.txtbxInsertConfirmPasswordId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertUserName.name();
        this.txtbxInsertUserNameId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertUserSurname.name();
        this.txtbxInsertUserSurnameId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertAge.name();
        this.txtbxInsertAgeId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.InsertPhone.name();
        this.txtbxInsertPhoneId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
        keyWebElement = CreateFinalUserFromKeys.SaveButton.name();
        this.SaveButtonId = WebSelector.getElementAttribute(keyWebComponent, keyWebElement);
    }

    public String getIdUserPlaceholder() throws NotFoundResourceException{
        WebElement txtbxInsertIdUser = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertIdUserId));
        String placeholder = "";
        placeholder = txtbxInsertIdUser.getAttribute("placeholder");
        return placeholder;
    }

    public void setIdUser(String userName) throws NotFoundResourceException {
        WebElement txtbxInsertIdUser = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertIdUserId));
        txtbxInsertIdUser.clear();
        txtbxInsertIdUser.sendKeys(userName);
    }

    public String getEmailPlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertEmail =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertEmailId));
        String placeholder = "";
        placeholder = txtbxInsertEmail.getAttribute("placeholder");
        return placeholder;
    }

    public void setEmail (String email) throws NotFoundResourceException {
        WebElement txtbxInsertEmail =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertEmailId));
        txtbxInsertEmail.clear();
        txtbxInsertEmail.sendKeys(email);
    }

    public String getPasswordPlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertPassword =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertPasswordId));
        String placeholder = "";
        placeholder = txtbxInsertPassword.getAttribute("placeholder");
        return placeholder;
    }

    public void setPassword(String password) throws NotFoundResourceException {
        WebElement txtbxInsertPassword =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertPasswordId));
        txtbxInsertPassword.clear();
        txtbxInsertPassword.sendKeys(password);
    }

    public String getConfirmPasswordPlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertConfirmPassword =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertConfirmPasswordId));
        String placeholder = "";
        placeholder = txtbxInsertConfirmPassword.getAttribute("placeholder");
        return placeholder;
    }

    public void setConfirmPassword(String confirmPassword) throws NotFoundResourceException {
        WebElement txtbxInsertConfirmPassword =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertConfirmPasswordId));
        txtbxInsertConfirmPassword.clear();
        txtbxInsertConfirmPassword.sendKeys(confirmPassword);
    }

    public String getUserNamePlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertUserName =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertUserNameId));
        String placeholder = "";
        placeholder = txtbxInsertUserName.getAttribute("placeholder");
        return placeholder;
    }

    public void setName(String userName) throws NotFoundResourceException {
        WebElement txtbxInsertUserName =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertUserNameId));
        txtbxInsertUserName.clear();
        txtbxInsertUserName.sendKeys(userName);
    }

    public String getUserSurnamePlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertUserSurname =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertUserSurnameId));
        String placeholder = "";
        placeholder = txtbxInsertUserSurname.getAttribute("placeholder");
        return placeholder;
    }

    public void setSurname(String userSurname) throws NotFoundResourceException {
        WebElement txtbxInsertUserSurname =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertUserSurnameId));
        txtbxInsertUserSurname.clear();
        txtbxInsertUserSurname.sendKeys(userSurname);
    }

    public String getUserAgePlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertAge =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertAgeId));
        String placeholder = "";
        placeholder = txtbxInsertAge.getAttribute("placeholder");
        return placeholder;
    }

    public void setAge(String userAge) throws NotFoundResourceException {
        WebElement txtbxInsertAge =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertAgeId));
        txtbxInsertAge.clear();
        txtbxInsertAge.sendKeys(userAge);
    }

    public String getUserPhonePlaceholder () throws NotFoundResourceException {
        WebElement txtbxInsertPhone =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertPhoneId));
        String placeholder = "";
        placeholder = txtbxInsertPhone.getAttribute("placeholder");
        return placeholder;
    }

    public void setPhone(String userPhone) throws NotFoundResourceException {
        WebElement txtbxInsertPhone =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(txtbxInsertPhoneId));
        txtbxInsertPhone.clear();
        txtbxInsertPhone.sendKeys(userPhone);
    }

    public String getSaveButtonText () throws NotFoundResourceException {
        WebElement saveButtonText =  Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(SaveButtonId));
        String text = "";
        text = saveButtonText.getText();
        return text;
    }

    public void save() throws NotFoundResourceException {
        WebElement saveButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(SaveButtonId));
        saveButton.click();
    }

    public boolean saveButtonIsDisplayed() throws NotFoundResourceException {
        WebElement saveButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(SaveButtonId));
        Boolean saveButtonDisplayed;
        saveButtonDisplayed = saveButton.isDisplayed();
        return saveButtonDisplayed;
    }

}

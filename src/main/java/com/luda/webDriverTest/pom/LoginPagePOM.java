package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Hashtable;

public class LoginPagePOM {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginPagePOM.class);
    private String keyWebComponent =  WebComponentKeys.loginForm.name();
    private String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
    private String submitTypeElement = WebElementTypesKeys.submit.name();
    private String labelTypeElement = WebElementTypesKeys.label.name();

    private Hashtable<String, ElementDTO> webElementsList = new Hashtable<String, ElementDTO>();

    private String insertIdUserKey =  LoginFormKeys.InsertName.name();
    private String insertPasswordKey = LoginFormKeys.InsertPassword.name();
    private String submitButtonKey = LoginFormKeys.SubmitButton.name();
    private String logInUnsuccessfullyKey = LoginFormKeys.UnsuccessfullyLabel.name();
    private String logInSuccessfullyKey = LoginFormKeys.IdUserNameSessionLabel.name();
    private String accessToCreateUserButtonKey = LoginFormKeys.AccessToCreateUser.name();

    private  WebDriver currentDriver;

    public LoginPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtr = new Hashtable<String, ElementDTO>();
        ElementDTO virtualWebElement;

        By idElement = WebSelector.getElementAttribute(keyWebComponent, insertIdUserKey);
        virtualWebElement = new ElementDTO(insertIdUserKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertIdUserKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertPasswordKey);
        virtualWebElement = new ElementDTO(insertPasswordKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertPasswordKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, submitButtonKey);
        virtualWebElement = new ElementDTO(submitButtonKey,idElement,submitTypeElement);
        virtualWebElementsAtr.put(submitButtonKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, logInUnsuccessfullyKey);
        virtualWebElement = new ElementDTO(logInUnsuccessfullyKey,idElement,labelTypeElement);
        virtualWebElementsAtr.put(logInUnsuccessfullyKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, logInSuccessfullyKey);
        virtualWebElement = new ElementDTO(logInSuccessfullyKey,idElement,labelTypeElement);
        virtualWebElementsAtr.put(logInSuccessfullyKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, accessToCreateUserButtonKey);
        virtualWebElement = new ElementDTO(accessToCreateUserButtonKey,idElement,submitTypeElement);
        virtualWebElementsAtr.put(accessToCreateUserButtonKey,virtualWebElement);

        setWebElementsList(virtualWebElementsAtr);
    }

    public void loadPlaceholderWebElements () throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtrList = PageHelper.updatePlaceholderWebElements(this.getWebElementsList());
        ElementDTO virtualWebElementDTO;
        for (String key : virtualWebElementsAtrList.keySet()) {
            virtualWebElementDTO = virtualWebElementsAtrList.get(key);
            this.updateWebElementAtrList(key,virtualWebElementDTO);
        }
    }

    public void setUserName(String userName) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertIdUserKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userName);
    }

    public void setPassword(String password) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertPasswordKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,password);
    }

    public void commit() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(submitButtonKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public Boolean logInUnsuccessfullyIsDisplayed() throws NotFoundResourceException{
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(logInUnsuccessfullyKey);
        Boolean logInUnsuccessfullyDisplayed;
        logInUnsuccessfullyDisplayed = PageHelper.elementDisplayed(virtualWebElementDTO);
        return logInUnsuccessfullyDisplayed;
    }

    public String getLogInUnsuccessfullyMessage() throws NotFoundResourceException{
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(logInUnsuccessfullyKey);
        virtualWebElementDTO = PageHelper.getLabelText(virtualWebElementDTO);
        String logInUnsuccessfullyMessage = virtualWebElementDTO.getText();
        return logInUnsuccessfullyMessage;
    }

    public String getLogInSuccessfullyMessage() throws NotFoundResourceException{
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(logInSuccessfullyKey);
        virtualWebElementDTO = PageHelper.getLabelText(virtualWebElementDTO);
        String logInSuccessfullyMessage = virtualWebElementDTO.getText();
        return logInSuccessfullyMessage;
    }

    public void navigateToCreateUser() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(accessToCreateUserButtonKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public Hashtable<String, ElementDTO> getWebElementsList() {
        return webElementsList;
    }

    private void setWebElementsList(Hashtable<String, ElementDTO> webElementsList) {
        this.webElementsList = webElementsList;
    }

    private void updateWebElementAtrList ( String webElementKey , ElementDTO webElementArt){
        this.getWebElementsList().replace(webElementKey,webElementArt);
    }
}

package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.CreateFinalUserFromKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;

public class CreateUserPagePOM {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CreateUserPagePOM.class);
    private String keyWebComponent =  WebComponentKeys.createFinalUserForm.name();
    private String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
    private String submitTypeElement = WebElementTypesKeys.submit.name();

    private Hashtable<String, ElementDTO> webElementsAtrList = new Hashtable<String, ElementDTO>();

    private String insertIdUserKey = CreateFinalUserFromKeys.InsertIdUser.name();
    private String insertEmailKey = CreateFinalUserFromKeys.InsertEmail.name();
    private String insertPasswordKey = CreateFinalUserFromKeys.InsertPassword.name();
    private String confirmPasswordKey = CreateFinalUserFromKeys.InsertConfirmPassword.name();
    private String insertUserNameKey = CreateFinalUserFromKeys.InsertUserName.name();
    private String insertUserSurnameKey = CreateFinalUserFromKeys.InsertUserSurname.name();
    private String insertAgeKey = CreateFinalUserFromKeys.InsertAge.name();
    private String insertPhoneKey = CreateFinalUserFromKeys.InsertPhone.name();
    private String saveButtonKey = CreateFinalUserFromKeys.SaveButton.name();

    private  WebDriver currentDriver;

    public CreateUserPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtr = new Hashtable<String, ElementDTO>();
        ElementDTO virtualWebElement;

        By idElement = WebSelector.getElementAttribute(keyWebComponent, insertIdUserKey);
        virtualWebElement = new ElementDTO(insertIdUserKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertIdUserKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertEmailKey);
        virtualWebElement = new ElementDTO(insertEmailKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertEmailKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertPasswordKey);
        virtualWebElement = new ElementDTO(insertPasswordKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertPasswordKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, confirmPasswordKey);
        virtualWebElement = new ElementDTO(confirmPasswordKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(confirmPasswordKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertUserNameKey);
        virtualWebElement = new ElementDTO(insertUserNameKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertUserNameKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertUserSurnameKey);
        virtualWebElement = new ElementDTO(insertUserSurnameKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertUserSurnameKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertAgeKey);
        virtualWebElement = new ElementDTO(insertAgeKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertAgeKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, insertPhoneKey);
        virtualWebElement = new ElementDTO(insertPhoneKey,idElement,txtBoxTypeElement);
        virtualWebElementsAtr.put(insertPhoneKey,virtualWebElement);

        idElement = WebSelector.getElementAttribute(keyWebComponent, saveButtonKey);
        virtualWebElement = new ElementDTO(saveButtonKey,idElement,submitTypeElement);
        virtualWebElementsAtr.put(saveButtonKey,virtualWebElement);

        setWebElementsAtrList(virtualWebElementsAtr);

    }

    public void loadPlaceholderWebElements () throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtrList = PageHelper.updatePlaceholderWebElements(this.getWebElementsAtrList());
        ElementDTO virtualWebElementDTO;
        for (String key : virtualWebElementsAtrList.keySet()) {
            virtualWebElementDTO = virtualWebElementsAtrList.get(key);
            this.updateWebElementAtrList(key,virtualWebElementDTO);
        }
    }

    public void setIdUser(String userName) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertIdUserKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userName);
    }

    public void setEmail (String email) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertEmailKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,email);
    }

    public void setPassword(String password) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertPasswordKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,password);
    }

    public void setConfirmPassword(String confirmPassword) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(confirmPasswordKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,confirmPassword);
    }

    public void setName(String userName) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertUserNameKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userName);
    }

    public void setSurname(String userSurname) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertUserSurnameKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userSurname);
    }

    public void setAge(String userAge) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertAgeKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userAge);
    }

    public void setPhone(String userPhone) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(insertPhoneKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,userPhone);
    }

    public void save() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(saveButtonKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public boolean saveButtonIsDisplayed() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsAtrList().get(saveButtonKey);
        PageHelper.elementDisplayed(virtualWebElementDTO);
        boolean saveButtonDisplayed = PageHelper.elementDisplayed(virtualWebElementDTO);
        return saveButtonDisplayed;
    }

    public Hashtable<String, ElementDTO> getWebElementsAtrList() {
        return webElementsAtrList;
    }

    private void setWebElementsAtrList(Hashtable<String, ElementDTO> webElementsAtrList) {
        this.webElementsAtrList = webElementsAtrList;
    }

    private void updateWebElementAtrList ( String webElementKey , ElementDTO webElementArt){
        this.getWebElementsAtrList().replace(webElementKey,webElementArt);
    }
}

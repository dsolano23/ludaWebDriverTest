package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;

public class PageHelper {

    public static Hashtable<String, ElementDTO> updatePlaceholderWebElements (Hashtable<String, ElementDTO> virtualWebElementsAtrList) throws NotFoundResourceException {
        String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
        WebElement virtualWebElement;
        ElementDTO virtualWebElementArt;
        By virtualElementId;
        String virtualPlaceholder;
        for (String key : virtualWebElementsAtrList.keySet()) {
            if (virtualWebElementsAtrList.get(key).getType().equalsIgnoreCase(txtBoxTypeElement)){
                virtualWebElementArt = virtualWebElementsAtrList.get(key);
                virtualElementId = virtualWebElementArt.getIdElement();
                virtualWebElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(virtualElementId));
                virtualPlaceholder = virtualWebElement.getAttribute(ElementAttributeKeys.placeholder.name());
                virtualWebElementArt.setPlaceholder(virtualPlaceholder);
            }
        }
        return virtualWebElementsAtrList;
    }

    public static ElementDTO getLabelText ( ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement labelLogText = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        String labelText;
        labelText = labelLogText.getText();
        virtualWebElementDTO.setText(labelText);
        return virtualWebElementDTO;
    }

    public static void setTxtBoxText( ElementDTO virtualWebElementDTO, String textValue) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement txtbxInsertIdUser = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        txtbxInsertIdUser.clear();
        txtbxInsertIdUser.sendKeys(textValue);
    }

    public static boolean elementDisplayed (ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement =Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        Boolean elementDisplayed;
        elementDisplayed = virtualElement.isDisplayed();
        return elementDisplayed;
    }

    public static void clickOnElement (ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement createUserButton = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        createUserButton.click();
    }

}

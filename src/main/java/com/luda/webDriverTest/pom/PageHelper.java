package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class PageHelper {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PageHelper.class);

    public static ElementDTO createNewWebElementDTO ( String keyWebComponent, String elementKey, String elementType) throws NotFoundResourceException {
        ElementDTO virtualWebElement;
        By idElement = WebSelector.getElementAttribute(keyWebComponent, elementKey);
        virtualWebElement = new ElementDTO(elementKey,idElement,elementType);
        return virtualWebElement;
    }

    public static TableDTO createNewTableDTO ( String keyWebComponent, String elementKey) throws NotFoundResourceException {
        TableDTO virtualTable;
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.xpathBase.name());
        int firstRow = parseInt(WebSelector.getElementAttribute(keyWebComponent,elementKey,ElementAttributeKeys.firstRow.name()));
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.baseCurrentRow.name());
        String columnDescriptionMolecule = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionMoleculeCode.name());
        String columnDescription = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionCode.name());
        virtualTable = new TableDTO(elementKey, xpathBase, firstRow, baseCurrentRow, columnDescriptionMolecule, columnDescription);

        return virtualTable;
    }

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

    public static String findItemRowNum(WebElement itemsResultSearch, String descriptionItem, TableDTO tableDTO ) throws NotFoundResourceException {
        List<WebElement> rows  = itemsResultSearch.findElements(By.tagName("tr"));

        String xpathBase = tableDTO.getXpathBase();
        int firstRow = tableDTO.getFirstRow();
        String baseCurrentRow = tableDTO.getBaseCurrentRow();
        String columnDescriptionMolecule = tableDTO.getColumnDescriptionMolecule();
        String columnDescription = tableDTO.getColumnDescription();

        String trRowValue="";
        WebElement virtualCellDescriptionMolecule;
        WebElement virtualCellDescription;

        for(int rowNum=firstRow;rowNum<=rows.size();rowNum++)
        {
            String currentRow = baseCurrentRow + rowNum + "]";
            String xpathValue = xpathBase + currentRow + columnDescriptionMolecule;
            LOGGER.debug( "xpath " + xpathValue );
            virtualCellDescriptionMolecule = itemsResultSearch.findElement(By.xpath(xpathValue));
            LOGGER.debug("New Item found virtualCellDescriptionMolecule:  " + virtualCellDescriptionMolecule.getText());
            xpathValue = xpathBase + currentRow + columnDescription;
            LOGGER.debug( "xpath " + xpathValue );
            virtualCellDescription = itemsResultSearch.findElement(By.xpath(xpathValue));
            LOGGER.debug("New Item found virtualCellDescription:  " + virtualCellDescription.getText());
            LOGGER.info("The search item is:  " + descriptionItem);
            if (virtualCellDescriptionMolecule.getText().trim().equalsIgnoreCase(descriptionItem) || virtualCellDescription.getText().trim().equalsIgnoreCase(descriptionItem)){
                LOGGER.info("Found item with description: " + virtualCellDescriptionMolecule.getText() + " in the " + tableDTO.getElementKey());
                LOGGER.info("Found item with description: " + virtualCellDescription.getText() + " in the " + tableDTO.getElementKey());
                trRowValue = currentRow;
                break;
            }
        }
        return trRowValue;
    }

    public static ElementDTO getLabelText ( ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement labelLogText = Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(elementId));
        String labelText;
        labelText = labelLogText.getText();
        virtualWebElementDTO.setText(labelText);
        return virtualWebElementDTO;
    }

    public static void setTxtBoxText( ElementDTO virtualWebElementDTO, String textValue) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement txtbxInsert = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        txtbxInsert.clear();
        txtbxInsert.sendKeys(textValue);
    }

    public static String getElementAttributeValue (ElementDTO virtualWebElementDTO, String attribute) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        //WebElement virtualElement =Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        WebElement virtualElement =Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(elementId));
        String  attributeValue;
        attributeValue = virtualElement.getAttribute(attribute.trim());
        return attributeValue;
    }

    public static boolean elementDisplayed (ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        Boolean elementDisplayed;
        elementDisplayed = virtualElement.isDisplayed();
        return elementDisplayed;
    }

    public static boolean elementEnabled (ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        Boolean elementEnabled;
        elementEnabled = virtualElement.isEnabled();
        return elementEnabled;
    }

    public static void clickOnElement (ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        virtualElement.click();
    }

    public static void clickOnElement (WebElement itemsResultSearch, ElementDTO virtualWebElementDTO) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement = itemsResultSearch.findElement(elementId);
        virtualElement.click();
    }


    public static void selectAutoCompResult(int resultNumber ) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.setAutoDelay(10);
        robot.setAutoWaitForIdle(true);
        for(int i=0; i< resultNumber; i++){
            robot.keyPress(KeyEvent.VK_DOWN);
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        TimeUnit.SECONDS.sleep(1);
    }

    public static void moveMouseToCoordinates ( int x, int y) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.setAutoDelay(10);
        robot.setAutoWaitForIdle(true);
        robot.mouseMove(x,y);
        TimeUnit.SECONDS.sleep(1);
        robot.mousePress(InputEvent.BUTTON1_MASK );
    }

    public static void getElementCoordinates(ElementDTO virtualWebElementDTO) throws NotFoundResourceException, InterruptedException, AWTException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement virtualElement = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));

        Point classname = virtualElement.getLocation();
        int xcordi = classname.getX();
        LOGGER.debug("Element's Position from left side "+xcordi +" pixels.");
        int ycordi = classname.getY();
        LOGGER.debug("Element's Position from top "+ycordi +" pixels.");
        PageHelper.moveMouseToCoordinates(xcordi,ycordi);
    }

    public static WebElement getItemsInTable( ElementDTO virtualWebElementDTO ) throws NotFoundResourceException {
        By elementId = virtualWebElementDTO.getIdElement();
        WebElement itemsResultSearch;
        itemsResultSearch = Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementId));
        return itemsResultSearch;
    }
}

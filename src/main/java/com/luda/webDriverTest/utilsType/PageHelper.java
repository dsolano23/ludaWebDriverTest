package com.luda.webDriverTest.utilsType;

import com.luda.webDriverTest.beans.*;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
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

    public static ElementDTO createNewWebElementDTO (String keyWebComponent, String elementKey, String elementType) throws NotFoundResourceException {
        ElementDTO virtualWebElement;
        By idElement = WebSelector.getElementAttribute(keyWebComponent, elementKey);
        virtualWebElement = new ElementDTO(elementKey,idElement,elementType);
        return virtualWebElement;
    }

    public static StockItemsTableDTO createNewStockTableDTO (String keyWebComponent, String elementKey) throws NotFoundResourceException {
        StockItemsTableDTO virtualStockTable;
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.xpathBase.name());
        int firstRow = parseInt(WebSelector.getElementAttribute(keyWebComponent,elementKey,ElementAttributeKeys.firstRow.name()));
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.baseCurrentRow.name());
        String mainSearchColumn = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionMolecule.name());
        String columnFamily = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnFamily.name());
        String columnPrescription = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnPrescription.name());
        String columnActions = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnActions.name());
        virtualStockTable = new StockItemsTableDTO(elementKey, xpathBase, firstRow, baseCurrentRow, mainSearchColumn, columnFamily, columnPrescription, columnActions);
        return virtualStockTable;
    }

    public static CartIemTableDTO createNewCartIemTableDTO (String keyWebComponent, String elementKey) throws NotFoundResourceException {
        CartIemTableDTO virtualStockTable;
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.xpathBase.name());
        int firstRow = parseInt(WebSelector.getElementAttribute(keyWebComponent,elementKey,ElementAttributeKeys.firstRow.name()));
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.baseCurrentRow.name());
        String mainSearchColumn = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionMolecule.name());
        String secondarySearchColumn = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionItem.name());
        String columnActions = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnActions.name());
        virtualStockTable = new CartIemTableDTO(elementKey, xpathBase, firstRow, baseCurrentRow, mainSearchColumn, secondarySearchColumn, columnActions);
        return virtualStockTable;
    }

    public static EndBookingItemTableDTO createNewEndBookingItemTableDTO (String keyWebComponent, String elementKey) throws NotFoundResourceException {
        EndBookingItemTableDTO virtualStockTable;
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.xpathBase.name());
        int firstRow = parseInt(WebSelector.getElementAttribute(keyWebComponent,elementKey,ElementAttributeKeys.firstRow.name()));
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.baseCurrentRow.name());
        String mainSearchColumn = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnDescriptionMolecule.name());
        String columnAmount = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnAmount.name());
        virtualStockTable = new EndBookingItemTableDTO(elementKey, xpathBase, firstRow, baseCurrentRow, mainSearchColumn, columnAmount);
        return virtualStockTable;
    }

    public static EndBookingPharmacyTableDTO createNewEndBookingPharmacyTableDTO (String keyWebComponent, String elementKey) throws NotFoundResourceException {
        EndBookingPharmacyTableDTO virtualStockTable;
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.xpathBase.name());
        int firstRow = parseInt(WebSelector.getElementAttribute(keyWebComponent,elementKey,ElementAttributeKeys.firstRow.name()));
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.baseCurrentRow.name());
        String mainSearchColumn = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnPharmacyName.name());
        String columnPharmacyAddress = WebSelector.getElementAttribute(keyWebComponent, elementKey, ElementAttributeKeys.columnPharmacyAddress.name());
        virtualStockTable = new EndBookingPharmacyTableDTO(elementKey, xpathBase, firstRow, baseCurrentRow, mainSearchColumn, columnPharmacyAddress);
        return virtualStockTable;
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

    public static String findItemRowNum(WebElement itemsResultSearch, String descriptionItem, BaseTableDTO tableDTO ) throws NotFoundResourceException {
        //List<WebElement> rows  = itemsResultSearch.findElements(By.tagName("tr"));
        String xpathBase = tableDTO.getXpathBase();
        List<WebElement> rows  = itemsResultSearch.findElement(By.xpath(xpathBase)).findElements(By.tagName("tr"));
        int firstRow = tableDTO.getFirstRow();
        String baseCurrentRow = tableDTO.getBaseCurrentRow();
        String mainSearchColumn = tableDTO.getMainSearchColumn();
        String secondarySearchColumn = tableDTO.getSecondarySearchColumn();
        String trRowValue="";
        WebElement virtualMainSearchColumn;
        String searchedMainCellValue = "";
        WebElement virtualSecondarySearchColumn;
        String searchedSecondaryCellValue = "";
        LOGGER.debug("Value of rows.size():" + rows.size() );
        LOGGER.debug("Value of firstRow: " + firstRow );
        LOGGER.debug("Value of search item: " + descriptionItem);
        LOGGER.debug("Value of mainSearchColumn: " + mainSearchColumn);
        LOGGER.debug("Value of secondarySearchColumn: " + secondarySearchColumn);
        for(int rowNum=firstRow;rowNum<=rows.size();rowNum++){
            String currentRow = baseCurrentRow + rowNum + "]";
            String xpathValue = xpathBase + currentRow + mainSearchColumn;
            LOGGER.debug( "xpath " + xpathValue );
            virtualMainSearchColumn = itemsResultSearch.findElement(By.xpath(xpathValue));
            LOGGER.debug("New Item found mainSearchColumn:  " + virtualMainSearchColumn.getText());
            searchedMainCellValue =  virtualMainSearchColumn.getText();

            if (!secondarySearchColumn.equalsIgnoreCase("")){
                xpathValue = xpathBase + currentRow + secondarySearchColumn;
                LOGGER.debug( "xpath " + xpathValue );
                virtualSecondarySearchColumn = itemsResultSearch.findElement(By.xpath(xpathValue));
                LOGGER.debug("New Item found secondarySearchColumn:  " + virtualSecondarySearchColumn.getText());
                searchedSecondaryCellValue = virtualSecondarySearchColumn.getText();
            }

            LOGGER.info("The search item is:  " + descriptionItem);
            if (searchedMainCellValue.trim().equalsIgnoreCase(descriptionItem) || searchedSecondaryCellValue.trim().equalsIgnoreCase(descriptionItem)){
                LOGGER.info("Found item with description: " + searchedMainCellValue + " in the " + tableDTO.getElementKey());
                LOGGER.info("Found item with description: " + searchedSecondaryCellValue + " in the " + tableDTO.getElementKey());
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
        LOGGER.debug("Value of ID: " + elementId.toString());
        WebElement virtualElement =Hooks.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(elementId));
        String  attributeValue;
        attributeValue = virtualElement.getAttribute(attribute.trim());
        LOGGER.debug("Value of attributeValue: " +attributeValue);
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

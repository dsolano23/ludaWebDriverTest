package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class EndBookingPagePOM {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EndBookingPagePOM.class);
    private String keyWebComponent =  WebComponentKeys.endBookingPanel.name();
    private String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
    private String buttonTypeElement = WebElementTypesKeys.button.name();
    private String submitTypeElement = WebElementTypesKeys.submit.name();
    private String labelTypeElement = WebElementTypesKeys.label.name();
    private String containerTypeElement = WebElementTypesKeys.container.name();
    private String tableTypeElement = WebElementTypesKeys.table.name();

    private Hashtable<String, ElementDTO> webElementsList = new Hashtable<String, ElementDTO>();
    private Hashtable<String, TableDTO> tableList = new Hashtable<String, TableDTO>();
    private String endBookingPanelKey = EndBookingPanelKeys.endBookingPanel.name();
    private String endBookButtonChangePharmacyKey = EndBookingPanelKeys.endBookButtonChangePharmacy.name();
    private String endBookButtonReturnSelectItemsKey = EndBookingPanelKeys.endBookButtonReturnSelectItems.name();
    private String endBookButtonSummitKey = EndBookingPanelKeys.endBookButtonSummit.name();
    private String endBookButtonNewBookingKey = EndBookingPanelKeys.endBookButtonNewBooking.name();
    private String endBookItemsTableKey = EndBookingPanelKeys.endBookItemsTable.name();
    private String endBookPharmacyTableKey = EndBookingPanelKeys.endBookPharmacyTable.name();

    private  WebDriver currentDriver;

    public EndBookingPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElements = new Hashtable<String, ElementDTO>();
        ElementDTO virtualWebElement;
        Hashtable<String, TableDTO> virtualTables = new Hashtable<String, TableDTO>();
        TableDTO virtualTableDTO;
        String classAttribute = ElementAttributeKeys.classAtr.name();

        virtualWebElement = createNewWebElementDTO(endBookingPanelKey,containerTypeElement);
        virtualWebElement.setClassAtr(WebSelector.getElementAttribute(keyWebComponent, endBookingPanelKey, classAttribute));
        virtualWebElements.put(endBookingPanelKey,virtualWebElement);
        virtualWebElements.put(endBookButtonChangePharmacyKey,createNewWebElementDTO(endBookButtonChangePharmacyKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonReturnSelectItemsKey,createNewWebElementDTO(endBookButtonReturnSelectItemsKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonNewBookingKey,createNewWebElementDTO(endBookButtonNewBookingKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonSummitKey,createNewWebElementDTO(endBookButtonSummitKey,submitTypeElement));
        virtualWebElements.put(endBookItemsTableKey,createNewWebElementDTO(endBookItemsTableKey,tableTypeElement));
        virtualTableDTO = PageHelper.createNewTableDTO(keyWebComponent, endBookItemsTableKey);
        String columnAmount = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.columnAmountCode.name());
        virtualTableDTO.setColumnAmount(columnAmount);
        virtualTables.put(endBookItemsTableKey,virtualTableDTO);
        virtualWebElements.put(endBookPharmacyTableKey,createNewWebElementDTO(endBookPharmacyTableKey,tableTypeElement));

        setTableList(virtualTables);
        setWebElementsList(virtualWebElements);
    }

    private  ElementDTO createNewWebElementDTO ( String elementKey, String elementType) throws NotFoundResourceException {
        ElementDTO virtualWebElement;
        By idElement = WebSelector.getElementAttribute(keyWebComponent, elementKey);
        virtualWebElement = new ElementDTO(elementKey,idElement,elementType);
        return virtualWebElement;
    }

    public void loadPlaceholderWebElements () throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtrList = PageHelper.updatePlaceholderWebElements(this.getWebElementsList());
        ElementDTO virtualWebElementDTO;
        for (String key : virtualWebElementsAtrList.keySet()) {
            virtualWebElementDTO = virtualWebElementsAtrList.get(key);
            this.updateWebElementAtrList(key,virtualWebElementDTO);
        }
    }



    public boolean endBookingPanelIsDisplayed() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookingPanelKey);
        String attribute = "class";
        Boolean endBookingPanelDisplayed = false;
        String classAtrCurrentValue = PageHelper.getElementAttributeValue(virtualWebElementDTO,attribute);
        LOGGER.debug("Values : " + classAtrCurrentValue);
        if (!classAtrCurrentValue.equalsIgnoreCase("") && classAtrCurrentValue.equalsIgnoreCase(virtualWebElementDTO.getClassAtr())){
            endBookingPanelDisplayed = true;
        }
        return endBookingPanelDisplayed;
    }

    private WebElement findRowInItemsTable(WebElement itemsResultSearch, String descriptionItem ) throws NotFoundResourceException {
        List<WebElement> rows  = itemsResultSearch.findElements(By.tagName("tr"));
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.xpathBase.name());
        String columnDescription = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.columnDescriptionCode.name());
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.baseCurrentRow.name());
        WebElement rowItemNeed = null;

        LOGGER.debug("rows size:" + rows.size());
        for(int rowNum=1;rowNum<rows.size();rowNum++)
        {
            String currentRow = baseCurrentRow + rowNum + "]";
            String xpath = xpathBase + currentRow + columnDescription;
            LOGGER.debug("xpath value:" +xpath);
            WebElement cellINameNeed = itemsResultSearch.findElement(By.xpath(xpath));
            LOGGER.debug("New Item found Description:  " + cellINameNeed.getText());

            if (cellINameNeed.getText().equalsIgnoreCase(descriptionItem)){
                LOGGER.debug("Found item with description: " + cellINameNeed.getText() + " in the endBooking");
                xpath = xpathBase + currentRow;
                LOGGER.debug("xpath value:" +xpath);
                rowItemNeed = itemsResultSearch.findElement(By.xpath(xpath));
            }
        }

        return rowItemNeed;
    }

    public WebElement getItemsInTable() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookItemsTableKey);
        WebElement itemsResultSearch = PageHelper.getItemsInTable(virtualWebElementDTO);
        return itemsResultSearch;
    }

    public int totalItemInEndBooking(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException, InterruptedException {
        TableDTO virtualTableDTO = this.getTableList().get(endBookItemsTableKey);
        String xpathBase = virtualTableDTO.getXpathBase();
        String columnAmount = virtualTableDTO.getColumnAmount();
        WebElement itemNum = null;
        int totalItemInTheCart = 0;
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,descriptionItem, this.getTableList().get(endBookItemsTableKey));
        if (!trRowValue.equalsIgnoreCase("")){
            String xpathValue = xpathBase + trRowValue + columnAmount;
            itemNum = itemsResultSearch.findElement(By.xpath(xpathValue));
            if (!itemNum.getText().equalsIgnoreCase("")){
                totalItemInTheCart = parseInt(itemNum.getText().trim());
            }
        }
        return totalItemInTheCart;
        /*
        String xpathBase = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.xpathBase.name());
        String columnAmount = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.columnAmountCode.name());
        String baseCurrentRow = WebSelector.getElementAttribute(keyWebComponent, endBookItemsTableKey, ElementAttributeKeys.baseCurrentRow.name());
        String currentRow = baseCurrentRow + "1]";
        String xpath = xpathBase + currentRow + columnAmount;

        int totalItemInTheCart = 0;
        itemsResultSearch = findRowInItemsTable(itemsResultSearch,descriptionItem);

        if (itemsResultSearch!=null){
            ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookItemsTableKey);
            LOGGER.debug("Values OF itemsResultSearch: " + itemsResultSearch.getText());
            WebElement itemNum = itemsResultSearch.findElement(By.xpath(xpath));
            LOGGER.debug("Values OF itemNum: " +itemNum.getText());
            if (!itemNum.getText().equalsIgnoreCase("")){
                totalItemInTheCart = parseInt(itemNum.getText().trim());
            }
        }
        return totalItemInTheCart;*/
    }

    public void changePharmacy() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookButtonChangePharmacyKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public void comeBack() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookButtonReturnSelectItemsKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public void newBooking() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookButtonNewBookingKey);
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

    public Hashtable<String, TableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(Hashtable<String, TableDTO> tableList) {
        this.tableList = tableList;
    }
}

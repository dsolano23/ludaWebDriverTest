package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.beans.ElementDTO;
import com.luda.webDriverTest.beans.StockItemsTableDTO;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.PageHelper;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.BookingPanelKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.Hashtable;

public class BookingPagePOM {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookingPagePOM.class);
    private String keyWebComponent =  WebComponentKeys.bookingPanel.name();
    private String txtBoxTypeElement = WebElementTypesKeys.txtBox.name();
    private String buttonTypeElement = WebElementTypesKeys.button.name();
    private String submitTypeElement = WebElementTypesKeys.submit.name();
    private String labelTypeElement = WebElementTypesKeys.label.name();
    private String containerTypeElement = WebElementTypesKeys.container.name();
    private String tableTypeElement = WebElementTypesKeys.table.name();

    private Hashtable<String, ElementDTO> webElementsList = new Hashtable<String, ElementDTO>();
    private Hashtable<String, StockItemsTableDTO> tableList = new Hashtable<String, StockItemsTableDTO>();
    private String insertLocationUserKey = BookingPanelKeys.insertLocationUser.name();
    private String bookingPanelKey = BookingPanelKeys.bookingPanel.name();
    private String insertItemToSearchKey = BookingPanelKeys.insertItemToSearch.name();
    private String showCartKey = BookingPanelKeys.showCart.name();
    private String itemsCartCountKey = BookingPanelKeys.itemsCartCount.name();
    private String searchItemButtonKey = BookingPanelKeys.searchItemButton.name();
    private String itemsTableKey = BookingPanelKeys.itemsTable.name();
    private String continueButtonKey = BookingPanelKeys.continueButton.name();

    private  WebDriver currentDriver;

    public BookingPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElements = new Hashtable<String, ElementDTO>();
        ElementDTO virtualWebElement;
        Hashtable<String, StockItemsTableDTO> virtualTables = new Hashtable<String, StockItemsTableDTO>();
        StockItemsTableDTO virtualStockTableDTO;
        String classAttribute = ElementAttributeKeys.classAtr.name();

        virtualWebElements.put(insertLocationUserKey,createNewWebElementDTO(insertLocationUserKey,txtBoxTypeElement));
        virtualWebElement = createNewWebElementDTO(bookingPanelKey,containerTypeElement);
        virtualWebElement.setClassAtr(WebSelector.getElementAttribute(keyWebComponent, bookingPanelKey, classAttribute));
        virtualWebElements.put(bookingPanelKey,virtualWebElement);
        virtualWebElements.put(insertItemToSearchKey,createNewWebElementDTO(insertItemToSearchKey,txtBoxTypeElement));
        virtualWebElements.put(showCartKey,createNewWebElementDTO(showCartKey,buttonTypeElement));
        virtualWebElements.put(itemsCartCountKey,createNewWebElementDTO(itemsCartCountKey,labelTypeElement));
        virtualWebElements.put(searchItemButtonKey,createNewWebElementDTO(searchItemButtonKey,submitTypeElement));
        virtualWebElements.put(itemsTableKey,createNewWebElementDTO(itemsTableKey,tableTypeElement));
        virtualStockTableDTO = PageHelper.createNewStockTableDTO(keyWebComponent, itemsTableKey);
        virtualTables.put(itemsTableKey,virtualStockTableDTO);
        virtualWebElements.put(continueButtonKey,createNewWebElementDTO(continueButtonKey,submitTypeElement));

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

    public void setLocationUser(String locationUser) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertLocationUserKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,locationUser);
    }

    public String getLocationUser() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertLocationUserKey);
        String locationUser;
        virtualWebElementDTO = PageHelper.getLabelText(virtualWebElementDTO);
        locationUser = virtualWebElementDTO.getText();
        return locationUser;
    }

    public String getLocationUserPlaceholder() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertLocationUserKey);
        String locationUser;
        loadPlaceholderWebElements();
        locationUser = virtualWebElementDTO.getPlaceholder();
        return locationUser;
    }

    public void selectAutoCompLocationResult (int resultNumber) throws InterruptedException, AWTException {
        PageHelper.selectAutoCompResult(resultNumber);
    }

    public boolean bookingPanelIsDisplayed() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(bookingPanelKey);
        String attribute = "class";
        String currentAttributeValue;
        Boolean bookingPanelDisplayed;
        currentAttributeValue = PageHelper.getElementAttributeValue(virtualWebElementDTO, attribute);
        bookingPanelDisplayed = virtualWebElementDTO.getClassAtr().equalsIgnoreCase(currentAttributeValue);
        return bookingPanelDisplayed;
    }

    public void setItemToSearch(String itemToSearch) throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(insertItemToSearchKey);
        PageHelper.setTxtBoxText(virtualWebElementDTO,itemToSearch);
    }

    public void searchItem() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(searchItemButtonKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }

    public boolean itemsTableIsDisplayed () throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(itemsTableKey);
        Boolean itemsTableDisplayed;
        itemsTableDisplayed = PageHelper.elementDisplayed(virtualWebElementDTO);
        return itemsTableDisplayed;
    }

    public WebElement getItemsTableResult() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(itemsTableKey);
        WebElement itemsResultSearch = PageHelper.getItemsInTable(virtualWebElementDTO);
        return itemsResultSearch;
    }

    public void putItemsWhichDescriptionToCart(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException {
        StockItemsTableDTO virtualTableDTO = this.getTableList().get(itemsTableKey);
        String xpathBase = virtualTableDTO.getXpathBase();
        String columnActions = virtualTableDTO.getColumnActions();
        WebElement actionCell = null;
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,descriptionItem, virtualTableDTO);
        if (!trRowValue.equalsIgnoreCase("")){
            String xpathValue = xpathBase + trRowValue + columnActions;
            actionCell = itemsResultSearch.findElement(By.xpath(xpathValue));
            actionCell.click();
        }
    }

    public void cartButtonClick() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(showCartKey);
        PageHelper.clickOnElement(virtualWebElementDTO);
    }


    public String getItemsInTheCart() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(itemsCartCountKey);
        virtualWebElementDTO = PageHelper.getLabelText(virtualWebElementDTO);
        String itemsInTheCart = virtualWebElementDTO.getText();
        return itemsInTheCart;
    }

    public boolean continueButtonIsEnabled () throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(continueButtonKey);
        String classAttributeValue;
        Boolean continueButtonEnabled=false;
        classAttributeValue = PageHelper.getElementAttributeValue(virtualWebElementDTO, "class");
        if (!classAttributeValue.contains("disabled")){
            continueButtonEnabled = true;
        }
        return continueButtonEnabled;
    }

    public void continueButtonClick() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(continueButtonKey);
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

    public Hashtable<String, StockItemsTableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(Hashtable<String, StockItemsTableDTO> tableList) {
        this.tableList = tableList;
    }
}

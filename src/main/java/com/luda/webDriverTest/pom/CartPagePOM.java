package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.beans.CartIemTableDTO;
import com.luda.webDriverTest.beans.ElementDTO;
import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.PageHelper;
import com.luda.webDriverTest.utilsType.constans.CartPanelKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class CartPagePOM {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CartPagePOM.class);
    BookingPagePOM bookingPage;
    private String keyWebComponent =  WebComponentKeys.cartPanel.name();
    private String containerTypeElement = WebElementTypesKeys.container.name();
    private String tableTypeElement = WebElementTypesKeys.table.name();
    private String buttonTypeElement = WebElementTypesKeys.button.name();
    private String labelTypeElement = WebElementTypesKeys.label.name();

    private Hashtable<String, ElementDTO> webElementsList = new Hashtable<String, ElementDTO>();
    private Hashtable<String, CartIemTableDTO> tableList = new Hashtable<String, CartIemTableDTO>();
    private String cartPanelKey = CartPanelKeys.cartPanel.name();
    private String cartItemsTableKey = CartPanelKeys.cartItemsTable.name();
    private String cartPharmacyTableKey = CartPanelKeys.cartPharmacyTable.name();
    private String cartButtonItemCountIncreaseKey = CartPanelKeys.cartButtonItemCountIncrease.name();
    private String cartButtonItemCountReduceKey = CartPanelKeys.cartButtonItemCountReduce.name();
    private String cartLabelItemCountKey = CartPanelKeys.cartLabelItemCount.name();
    private String cartButtonItemCountRemoveKey = CartPanelKeys.cartButtonItemCountRemove.name();

    private  WebDriver currentDriver;

    public CartPagePOM(WebDriver currentDriver) throws NotFoundResourceException {
        this.currentDriver = currentDriver;
        loadByIdElements();
    }

    private void loadByIdElements() throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElements = new Hashtable<String, ElementDTO>();
        Hashtable<String, CartIemTableDTO> virtualTables = new Hashtable<String, CartIemTableDTO>();
        CartIemTableDTO virtualTableDTO;
        virtualWebElements.put(cartPanelKey, PageHelper.createNewWebElementDTO(keyWebComponent,cartPanelKey,containerTypeElement));
        virtualWebElements.put(cartItemsTableKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartItemsTableKey,tableTypeElement));
        virtualTableDTO = PageHelper.createNewCartIemTableDTO(keyWebComponent, cartItemsTableKey);
        virtualTables.put(cartItemsTableKey,virtualTableDTO);
        virtualWebElements.put(cartPharmacyTableKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartPharmacyTableKey,tableTypeElement));
        virtualWebElements.put(cartButtonItemCountIncreaseKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartButtonItemCountIncreaseKey,buttonTypeElement));
        virtualWebElements.put(cartButtonItemCountReduceKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartButtonItemCountReduceKey,buttonTypeElement));
        virtualWebElements.put(cartLabelItemCountKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartLabelItemCountKey,labelTypeElement));
        virtualWebElements.put(cartButtonItemCountRemoveKey,PageHelper.createNewWebElementDTO(keyWebComponent,cartButtonItemCountRemoveKey,buttonTypeElement));
        setTableList(virtualTables);
        setWebElementsList(virtualWebElements);
    }

    public void loadPlaceholderWebElements () throws NotFoundResourceException {
        Hashtable<String, ElementDTO> virtualWebElementsAtrList = PageHelper.updatePlaceholderWebElements(this.getWebElementsList());
        ElementDTO virtualWebElementDTO;
        for (String key : virtualWebElementsAtrList.keySet()) {
            virtualWebElementDTO = virtualWebElementsAtrList.get(key);
            this.updateWebElementAtrList(key,virtualWebElementDTO);
        }
    }

    public void cartShow() throws NotFoundResourceException, InterruptedException {
        if (!isShowing()){
            bookingPage = new BookingPagePOM(Hooks.getWebDriver());
            bookingPage.cartButtonClick();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void cartHide() throws NotFoundResourceException, InterruptedException {
        if (isShowing()){
            bookingPage = new BookingPagePOM(Hooks.getWebDriver());
            bookingPage.cartButtonClick();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public boolean isShowing() throws NotFoundResourceException {
        Boolean cartPanelShowing = false;
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartPanelKey);
        String attribute = ElementAttributeKeys.style.name();
        String widthProperty = PageHelper.getElementAttributeValue(virtualWebElementDTO,attribute);

        if (!widthProperty.equalsIgnoreCase("")){
            String[] subValues;
            subValues = widthProperty.split("width:");
            widthProperty = subValues[1];
            subValues = widthProperty.split("%");
            widthProperty = subValues[0];
            int showPercent = parseInt(widthProperty.trim());
            if (showPercent>50){
                cartPanelShowing=true;
            }
        }
        return cartPanelShowing;
    }

    public WebElement getItemsInCart() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartItemsTableKey);
        WebElement itemsResultSearch;
        itemsResultSearch = PageHelper.getItemsInTable(virtualWebElementDTO);
        return itemsResultSearch;
    }

    private WebElement findActionCell (WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException {
        CartIemTableDTO virtualTableDTO = this.getTableList().get(cartItemsTableKey);
        String xpathBase = virtualTableDTO.getXpathBase();
        String columnActions = virtualTableDTO.getColumnActions();
        WebElement actionCell = null;
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,descriptionItem, this.getTableList().get(cartItemsTableKey));
        if (!trRowValue.equalsIgnoreCase("")){
            String xpathValue = xpathBase + trRowValue + columnActions;
            actionCell = itemsResultSearch.findElement(By.xpath(xpathValue));
        }
        return actionCell;
    }

    public boolean isItemInCart(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException, InterruptedException {
        boolean isItemInTheCart = false;
        CartIemTableDTO virtualTableDTO = this.getTableList().get(cartItemsTableKey);
        String xpathBase = virtualTableDTO.getXpathBase();
        String columnDescriptionMolecule = virtualTableDTO.getItemDescriptionMolecule();
        String columnDescription = virtualTableDTO.getItemDescription();
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,descriptionItem, virtualTableDTO);

        if (!trRowValue.equalsIgnoreCase("")){
            String xpathValue = xpathBase + trRowValue + columnDescriptionMolecule;
            WebElement virtualCellDescriptionMolecule = itemsResultSearch.findElement(By.xpath(xpathValue));
            xpathValue = xpathBase + trRowValue + columnDescription;
            WebElement virtualCellDescription = itemsResultSearch.findElement(By.xpath(xpathValue));

            if (virtualCellDescriptionMolecule.getText().trim().equalsIgnoreCase(descriptionItem) || virtualCellDescription.getText().trim().equalsIgnoreCase(descriptionItem)){
                isItemInTheCart = true;
            }
        }

        return isItemInTheCart;
    }

    public void addMoreCurrentItems(WebElement itemsResultSearch, String descriptionItem, int addMore) throws NotFoundResourceException, InterruptedException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartButtonItemCountIncreaseKey);
        WebElement actionCell = findActionCell(itemsResultSearch,descriptionItem);
        for(int addMoreNum=0;addMoreNum<addMore;addMoreNum++){
            PageHelper.clickOnElement(actionCell,virtualWebElementDTO);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void restCurrentItems(WebElement itemsResultSearch, String descriptionItem, int subtract) throws NotFoundResourceException, InterruptedException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartButtonItemCountReduceKey);
        WebElement actionCell = findActionCell(itemsResultSearch,descriptionItem);
        for(int subtractMoreNum=0;subtractMoreNum<subtract;subtractMoreNum++){
            PageHelper.clickOnElement(actionCell,virtualWebElementDTO);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void removeItemOfCart(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException, InterruptedException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartButtonItemCountRemoveKey);
        WebElement actionCell = findActionCell(itemsResultSearch,descriptionItem);
        PageHelper.clickOnElement(actionCell,virtualWebElementDTO);
        TimeUnit.SECONDS.sleep(1);
    }

    public void removeAllItemOfCart(WebElement itemsResultSearch) throws NotFoundResourceException, InterruptedException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartButtonItemCountRemoveKey);
        CartIemTableDTO virtualTableDTO = this.getTableList().get(cartItemsTableKey);
        List<WebElement> rows  = itemsResultSearch.findElements(By.tagName("tr"));
        String xpathBase = virtualTableDTO.getXpathBase();
        String baseCurrentRow = virtualTableDTO.getBaseCurrentRow();
        String columnActions = virtualTableDTO.getColumnActions();
        int firstRow = virtualTableDTO.getFirstRow();

        for(int rowNum=firstRow;rowNum<=rows.size();rowNum++)
        {
            String currentRow = baseCurrentRow + firstRow + "]";
            String xpathValue = xpathBase + currentRow + columnActions;
            LOGGER.debug( "xpath " + xpathValue );
            WebElement actionCell = itemsResultSearch.findElement(By.xpath(xpathValue));
            PageHelper.clickOnElement(actionCell,virtualWebElementDTO);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public int totalItemInTheCart(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException, InterruptedException {
        int totalItemInTheCart = 0;
        WebElement actionCell = findActionCell(itemsResultSearch,descriptionItem);

        if (actionCell!=null){
            ElementDTO virtualWebElementDTO = this.getWebElementsList().get(cartLabelItemCountKey);
            WebElement itemNum = actionCell.findElement(virtualWebElementDTO.getIdElement());
            if (!itemNum.getText().equalsIgnoreCase("")){
                totalItemInTheCart = parseInt(itemNum.getText().trim());
            }
        }
        return totalItemInTheCart;
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

    public Hashtable<String, CartIemTableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(Hashtable<String, CartIemTableDTO> tableList) {
        this.tableList = tableList;
    }
}

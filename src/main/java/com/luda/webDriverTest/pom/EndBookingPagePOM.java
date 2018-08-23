package com.luda.webDriverTest.pom;

import com.luda.webDriverTest.beans.ElementDTO;
import com.luda.webDriverTest.beans.EndBookingItemTableDTO;
import com.luda.webDriverTest.beans.EndBookingPharmacyTableDTO;
import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.utilsType.PageHelper;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.EndBookingPanelKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import com.luda.webDriverTest.utilsType.constans.WebElementTypesKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Hashtable;
import java.util.List;

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
    private Hashtable<String, EndBookingItemTableDTO> endBookItemTableList = new Hashtable<String, EndBookingItemTableDTO>();
    private Hashtable<String, EndBookingPharmacyTableDTO> endBookPharmacyTableList = new Hashtable<String, EndBookingPharmacyTableDTO>();
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
        Hashtable<String, EndBookingItemTableDTO> virtItemTables = new Hashtable<String, EndBookingItemTableDTO>();
        EndBookingItemTableDTO virtItemTableDTO;
        Hashtable<String, EndBookingPharmacyTableDTO> virtPharmacyTables = new Hashtable<String, EndBookingPharmacyTableDTO>();
        EndBookingPharmacyTableDTO virtPharmacyTableDTO;
        String classAttribute = ElementAttributeKeys.classAtr.name();

        virtualWebElement = createNewWebElementDTO(endBookingPanelKey,containerTypeElement);
        virtualWebElement.setClassAtr(WebSelector.getElementAttribute(keyWebComponent, endBookingPanelKey, classAttribute));
        virtualWebElements.put(endBookingPanelKey,virtualWebElement);
        virtualWebElements.put(endBookButtonChangePharmacyKey,createNewWebElementDTO(endBookButtonChangePharmacyKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonReturnSelectItemsKey,createNewWebElementDTO(endBookButtonReturnSelectItemsKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonNewBookingKey,createNewWebElementDTO(endBookButtonNewBookingKey,buttonTypeElement));
        virtualWebElements.put(endBookButtonSummitKey,createNewWebElementDTO(endBookButtonSummitKey,submitTypeElement));
        virtualWebElements.put(endBookItemsTableKey,createNewWebElementDTO(endBookItemsTableKey,tableTypeElement));
        virtItemTableDTO = PageHelper.createNewEndBookingItemTableDTO(keyWebComponent, endBookItemsTableKey);
        virtItemTables.put(endBookItemsTableKey,virtItemTableDTO);
        virtualWebElements.put(endBookPharmacyTableKey,createNewWebElementDTO(endBookPharmacyTableKey,tableTypeElement));
        virtPharmacyTableDTO = PageHelper.createNewEndBookingPharmacyTableDTO(keyWebComponent, endBookPharmacyTableKey);
        virtPharmacyTables.put(endBookPharmacyTableKey,virtPharmacyTableDTO);

        setEndBookItemTableList(virtItemTables);
        setEndBookPharmacyTableList(virtPharmacyTables);
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

    public WebElement getItemsInTable() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookItemsTableKey);
        WebElement itemsResultSearch = PageHelper.getItemsInTable(virtualWebElementDTO);
        return itemsResultSearch;
    }

    public int totalItemInEndBooking(WebElement itemsResultSearch, String descriptionItem) throws NotFoundResourceException, InterruptedException {
        EndBookingItemTableDTO virtualTableDTO = this.getEndBookItemTableList().get(endBookItemsTableKey);
        String xpathBase = virtualTableDTO.getXpathBase();
        String columnAmount = virtualTableDTO.getColumnAmount();
        WebElement itemNum = null;
        int totalItemInTheCart = 0;
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,descriptionItem, virtualTableDTO);
        if (!trRowValue.equalsIgnoreCase("")){
            String xpathValue = xpathBase + trRowValue + columnAmount;
            itemNum = itemsResultSearch.findElement(By.xpath(xpathValue));
            if (!itemNum.getText().equalsIgnoreCase("")){
                totalItemInTheCart = parseInt(itemNum.getText().trim());
            }
        }
        return totalItemInTheCart;
    }

    public WebElement getPharmacyTable() throws NotFoundResourceException {
        ElementDTO virtualWebElementDTO = this.getWebElementsList().get(endBookPharmacyTableKey);
        WebElement itemsResultSearch = PageHelper.getItemsInTable(virtualWebElementDTO);
        return itemsResultSearch;
    }

    public boolean isPharmacySelected(WebElement itemsResultSearch, String pharmacyName) throws NotFoundResourceException {
        EndBookingPharmacyTableDTO virtualTableDTO = this.getEndBookPharmacyTableList().get(endBookPharmacyTableKey);
        String trRowValue = PageHelper.findItemRowNum(itemsResultSearch,pharmacyName, virtualTableDTO);
        boolean found = false;
        if (!trRowValue.equalsIgnoreCase("")){
            found = true;
        }
        return found;
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

    private Hashtable<String, ElementDTO> getWebElementsList() {
        return webElementsList;
    }

    private void setWebElementsList(Hashtable<String, ElementDTO> webElementsList) {
        this.webElementsList = webElementsList;
    }

    private void updateWebElementAtrList ( String webElementKey , ElementDTO webElementArt){
        this.getWebElementsList().replace(webElementKey,webElementArt);
    }

    private Hashtable<String, EndBookingItemTableDTO> getEndBookItemTableList() {
        return endBookItemTableList;
    }

    private void setEndBookItemTableList(Hashtable<String, EndBookingItemTableDTO> endBookItemTableList) {
        this.endBookItemTableList = endBookItemTableList;
    }

    private Hashtable<String, EndBookingPharmacyTableDTO> getEndBookPharmacyTableList() {
        return endBookPharmacyTableList;
    }

    private void setEndBookPharmacyTableList(Hashtable<String, EndBookingPharmacyTableDTO> endBookPharmacyTableList) {
        this.endBookPharmacyTableList = endBookPharmacyTableList;
    }
}

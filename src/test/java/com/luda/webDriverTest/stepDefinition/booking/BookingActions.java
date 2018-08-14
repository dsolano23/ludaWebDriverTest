package com.luda.webDriverTest.stepDefinition.booking;

import com.luda.webDriverTest.enviroment.Hooks;
import com.luda.webDriverTest.utilsType.WebSelector;
import com.luda.webDriverTest.utilsType.constans.BookingPanelKeys;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingActions {

    /**
     * The Logger
     */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookingActions.class);
    @When("^I insert a user location address: (.+)$")
    public void i_insert_a_user_location_address(String userLocationAddress) throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.insertLocationUser.name();
        TimeUnit.SECONDS.sleep(3);
        WebElement insertAddress  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));


        insertAddress.clear();
        insertAddress.sendKeys(userLocationAddress);

        TimeUnit.SECONDS.sleep(1);

        Robot robot = new Robot();
        robot.setAutoDelay(10);
        robot.setAutoWaitForIdle(true);
        robot.keyPress(KeyEvent.VK_DOWN);
        TimeUnit.SECONDS.sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        /*

        TimeUnit.SECONDS.sleep(3);
        robot.mouseMove(450,250);
        robot.mousePress(InputEvent.BUTTON1_MASK );

        TimeUnit.SECONDS.sleep(3);

/*
        Actions builder = new Actions(Hooks.getWebDriver());
        Action mouseOverHome = builder
                .moveToElement(insertAddress)
                .click()
                .keyDown(Keys.SHIFT)
                .click()
                .build();
        mouseOverHome.perform();

        String bgColor = insertAddress.getCssValue("background-color");
        LOGGER.debug("Before hover: " + bgColor);

        bgColor = insertAddress.getCssValue("background-color");
        LOGGER.debug("After hover: " + bgColor);

        insertAddress  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.cbp-spmenu-s1.fondo:nth-child(2) div.ng-scope:nth-child(1) div.ng-scope:nth-child(2) div.row div.col-xs-1 div:nth-child(1) div.menu-toggle > button.c-hamburger.c-hamburger--htx")));
insertAddress.click();
insertAddress.sendKeys(Keys.DOWN);
        insertAddress.click();

        mouseOverHome = builder
                .click()
                .keyDown(Keys.SHIFT)
                .click()
                .build();

         bgColor = insertAddress.getCssValue("background-color");
        LOGGER.debug("Before hover: " + bgColor);
        mouseOverHome.perform();
        bgColor = insertAddress.getCssValue("background-color");
        LOGGER.debug("After hover: " + bgColor);

        /*
        LOGGER.debug("I insert a user location address:" + userLocationAddress);

        getWebDriver().findElement(By.xpath("//label[contains(text(),Maudes")).click();
        ElementDTO googleResult  =  Hooks.getWebDriverWait().until((ExpectedConditions.presenceOfElementLocated(By.id("resultStats"))));
        ElementDTO googleResult  =  Hooks.getWebDriverWait().until((ExpectedConditions.presenceOfElementLocated(By.id("keyword_suggest"))));
        List<ElementDTO> findElements = getWebDriver().findElements(By.xpath("//*[@id='rso']//h3/a"));
        List<ElementDTO> findElements = Hooks.getWebDriverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("suggest-left-cell"), 0));
        insertAddress  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.className("form-control ng-pristine ng-untouched ng-valid ng-isolate-scope")));
        LOGGER.debug("I insert a user location address:" + insertAddress);
        List<ElementDTO> findElements = Hooks.getWebDriverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("form-control ng-pristine ng-untouched ng-valid ng-isolate-scope"),0));


        this are all the links you like to visit
        for (ElementDTO webElement : findElements)
        {
            LOGGER.debug("Valor 0 text dentro del for:" + webElement.toString());
            LOGGER.debug("Valor 1 text dentro del for:" + webElement.getText());
            LOGGER.debug("Valor 2 text dentro del for:" + webElement.getAttribute("href"));
            LOGGER.debug("Valor 3 text dentro del for:" + webElement.getTagName());
        }*/
    }

    @When("^I find the item with the description (.+)$")
    public void i_find_the_item_with_the_description(String itemDescription) throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.insertItemToSearch.name();
        String attribute = ElementAttributeKeys.placeholder.name();

        WebElement insertItemToSearch  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), insertItemToSearch.getAttribute("placeholder").toLowerCase());
        TimeUnit.SECONDS.sleep(2);
        insertItemToSearch.clear();
        insertItemToSearch.sendKeys(itemDescription);
        keyWebElement = BookingPanelKeys.searchItemButton.name();
        attribute = ElementAttributeKeys.text.name();
        WebElement searchItemButton  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(WebSelector.getElementAttribute(keyWebComponent, keyWebElement)));
        Assert.assertEquals(WebSelector.getElementAttribute(keyWebComponent, keyWebElement, attribute ).toLowerCase(), searchItemButton.getText().toLowerCase());
        searchItemButton.click();
        TimeUnit.SECONDS.sleep(5);
    }

    @When("^I add the item (.+) to the cart$")
    public void i_add_the_item_to_the_cart(String itemDescription) throws Throwable {
        String keyWebComponent = WebComponentKeys.bookingPanel.name();
        String keyWebElement = BookingPanelKeys.itemsTable.name();

        WebElement itemsTable  =  Hooks.getWebDriverWait().until(ExpectedConditions.elementToBeClickable((WebSelector.getElementAttribute(keyWebComponent, keyWebElement))));
        List<WebElement> rows  = itemsTable.findElements(By.tagName("tr"));
        List<WebElement> columns   = itemsTable.findElements(By.tagName("th"));
        LOGGER.debug("Value of      rows: " + rows .size());
        LOGGER.debug("Value of   columns: " + columns .size());

        String xpathBase = "//tbody//";
        String nameColumn = "//td[1]";
        String addColumn = "//td[4]";

        for(int rnum=1;rnum<rows.size();rnum++)
        {
            String tr = "tr[" + rnum + "]";
            String xpath = xpathBase + tr + nameColumn;
            WebElement cellINameNeed = itemsTable.findElement(By.xpath(xpath));
            LOGGER.debug("Item found name:" + cellINameNeed.getText());
            LOGGER.debug("Item found name:" + itemDescription);
            if (cellINameNeed.getText().equalsIgnoreCase(itemDescription)){
                LOGGER.debug("Item found name:" + cellINameNeed.getText());
                xpath = xpathBase + tr + addColumn;
                WebElement addElement = itemsTable.findElement(By.xpath(xpath));
                addElement.click();
                TimeUnit.SECONDS.sleep(2);
            }
        }

    }

}

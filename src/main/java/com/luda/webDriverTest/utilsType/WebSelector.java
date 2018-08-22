package com.luda.webDriverTest.utilsType;

import com.luda.webDriverTest.exception.NotFoundResourceException;
import com.luda.webDriverTest.pom.ElementDTO;
import com.luda.webDriverTest.utilsType.constans.ElementAttributeKeys;
import com.luda.webDriverTest.utilsType.constans.WebComponentKeys;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

public class WebSelector {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WebSelector.class);

    private static String PropertiesDir = new File( "." ).getAbsolutePath();
    private static Hashtable<String, Properties> propertiesList = new Hashtable<String, Properties>();


    /**
     * Always return the same instance (singleton)
     * @return
     */
    private static Properties getWebElementsProps(String keyWebComponent ) throws NotFoundResourceException {

        if (keyWebComponent.equalsIgnoreCase(WebComponentKeys.loginForm.name()) ) {
            if (getPropertiesList().get(keyWebComponent) == null){
                Properties loginForm;
                String fileName = WebComponentKeys.loginForm.name();
                loginForm = loadWebElementProperties(fileName);
                getPropertiesList().put(keyWebComponent,loginForm);
            }
        }else if (keyWebComponent.equalsIgnoreCase(WebComponentKeys.createFinalUserForm.name()) ) {
            if (getPropertiesList().get(keyWebComponent) == null ){
                Properties createFinalUserForm;
                String fileName = WebComponentKeys.createFinalUserForm.name();
                createFinalUserForm = loadWebElementProperties(fileName);
                getPropertiesList().put(keyWebComponent,createFinalUserForm);
            }
        }else if (keyWebComponent.equalsIgnoreCase(WebComponentKeys.bookingPanel.name()) ) {
            if (getPropertiesList().get(keyWebComponent) == null){
                Properties bookingPanel;
                String fileName = WebComponentKeys.bookingPanel.name();
                bookingPanel = loadWebElementProperties(fileName);
                getPropertiesList().put(keyWebComponent,bookingPanel);
            }
        }else if (keyWebComponent.equalsIgnoreCase(WebComponentKeys.cartPanel.name()) ) {
            if (getPropertiesList().get(keyWebComponent) == null){
                Properties cartPanel;
                String fileName = WebComponentKeys.cartPanel.name();
                cartPanel = loadWebElementProperties(fileName);
                getPropertiesList().put(keyWebComponent,cartPanel);
            }
        }else if (keyWebComponent.equalsIgnoreCase(WebComponentKeys.endBookingPanel.name()) ) {
            if (getPropertiesList().get(keyWebComponent) == null){
                Properties cartPanel;
                String fileName = WebComponentKeys.endBookingPanel.name();
                cartPanel = loadWebElementProperties(fileName);
                getPropertiesList().put(keyWebComponent,cartPanel);
            }
        }

        return getPropertiesList().get(keyWebComponent);
    }

    private static Properties loadWebElementProperties(String keyWebComponent) throws NotFoundResourceException {
        Properties props2 = new Properties();
        InputStream input = null;
        String path = "/src/main/Resources/webElementsProperties/";

        String webElemntsProperties = PropertiesDir + path + keyWebComponent + ".properties";
        try {

            boolean exist = new File(webElemntsProperties).exists();
            if(exist) {
                input = new FileInputStream(webElemntsProperties);
                // load a properties file
                props2.load(input);
            }else {
                throw new NotFoundResourceException("The file "+ webElemntsProperties + " does not exists");
            }


        } catch (IOException ex) {
            ex.printStackTrace();
            throw new NotFoundResourceException(String.format("%s %s", "Error on access to"+  webElemntsProperties +" does not exists ", ex.getMessage() ));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props2;
    }

    public static String getElementAttribute (String keyWebComponent, String key, String attribute) throws NotFoundResourceException {
        String textValue="";
        LOGGER.debug("The keyWebComponent is: " + keyWebComponent + " the key is " + key + " and the attribute is: " + attribute);
        if (attribute.equalsIgnoreCase(ElementAttributeKeys.classAtr.name())){
            //TODO Optimize for multi language with a relaccionation to environment configuration extracting the set language
            attribute = "class";
            key = key + "." + attribute;
            LOGGER.debug("Locate class attribute the final Key is: " + key);
            textValue = WebSelector.getWebElementsProps(keyWebComponent).getProperty(key);
            LOGGER.debug("The value of " + key + " is: " + textValue);
        }else if (attribute.equalsIgnoreCase(ElementAttributeKeys.placeholder.name())|| attribute.equalsIgnoreCase(ElementAttributeKeys.text.name())){
            key = key + "." + attribute + ".es";
            textValue = WebSelector.getWebElementsProps(keyWebComponent).getProperty(key);
            LOGGER.debug("The value of " + key + " is: " + textValue);
        }else {
            key = key + "." + attribute;
            LOGGER.debug("Locate a simple attribute the final Key is: " + key);
            textValue = WebSelector.getWebElementsProps(keyWebComponent).getProperty(key);
            LOGGER.debug("The value of " + key + " is: " + textValue);
        }

        return textValue;
    }

    public static By getElementAttribute(String keyWebComponent, String key) throws NotFoundResourceException {
        By target = null;
        String[] subValues;
        key = key + "." + ElementAttributeKeys.id.name();

        String value = WebSelector.getWebElementsProps(keyWebComponent).getProperty(key);
        LOGGER.debug("The " + key + " property has the value: " + value);
        if(value.startsWith(ElementAttributeKeys.byId.name())){
            subValues = value.split(ElementAttributeKeys.byId.name()+ ".");
            value = subValues[1];
            target = By.id(value);
            LOGGER.debug("The location mode is by id and final value is: " + value);
        }else if(value.startsWith(ElementAttributeKeys.byName.name())){
            subValues = value.split(ElementAttributeKeys.byName.name()+ ".");
            value = subValues[1];
            target = By.name(value);
            LOGGER.debug("The location mode is by name and final value is: " + value);
        }else if(value.startsWith(ElementAttributeKeys.byCss.name())){
            subValues = value.split(ElementAttributeKeys.byCss.name()+ ".");
            value = subValues[1];
            target = By.cssSelector(value);
            LOGGER.debug("The location mode is by css and final value is: " + value);
        }else if(value.startsWith(ElementAttributeKeys.byClass.name())){
            subValues = value.split(ElementAttributeKeys.byClass.name()+ ".");
            value = subValues[1];
            target = By.className(value);
            LOGGER.debug("The location mode is by css and final value is: " + value);
        }
        return target;
    }

    private static Hashtable<String, Properties> getPropertiesList() {
        return propertiesList;
    }

    private static void setPropertiesList(Hashtable<String, Properties> propertiesList) {
        WebSelector.propertiesList = propertiesList;
    }

}

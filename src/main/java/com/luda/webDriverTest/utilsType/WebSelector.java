package com.luda.webDriverTest.utilsType;

import com.luda.webDriverTest.exception.NotFoundResourceException;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebSelector {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WebSelector.class);

    private static String PropertiesDir = new File( "." ).getAbsolutePath();
    private static Properties props = null;

    /**
     * Always return the same instance (singleton)
     * @return
     */
    private static Properties getWebElemntsProps() throws NotFoundResourceException {
        if (props == null){
            props = new Properties();
            String fileName = "loginElements";
            props.putAll(loadWebElemntsProperties(fileName));
            fileName = "createFinalUser";
            props.putAll(loadWebElemntsProperties(fileName));
            fileName = "newBooking";
            props.putAll(loadWebElemntsProperties(fileName));
        }
        return props;
    }

    private static Properties loadWebElemntsProperties(String fileName) throws NotFoundResourceException {
        Properties props2 = new Properties();
        InputStream input = null;
        String path = "/src/main/Resources/webElementsProperties/";

        String webElemntsProperties = PropertiesDir + path + fileName + ".properties";
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

    public static String getWebElementPlaceholder(String key) throws NotFoundResourceException {
        String placeholder="";
        //TODO Optimize for multi language with a relaccionation to environment configuration extracting the set language
        key = key + ".placeholder" + ".es";
        placeholder = WebSelector.getWebElemntsProps().getProperty(key);
        return placeholder;
    }

    public static String getWebElementText(String key) throws NotFoundResourceException {
        String text="";
        //TODO Optimize for multi language with a relaccionation to environment configuration extracting the set language
        key = key + ".text" + ".es";
        text = WebSelector.getWebElemntsProps().getProperty(key);
        return text;
    }
    public static By getWebElementId(String key) throws NotFoundResourceException {
        By target = null;
        String[] subValues = null;
        key = key + ".id";

        String value = WebSelector.getWebElemntsProps().getProperty(key);
        LOGGER.debug("The " + key + " property has the value: " + value);
        if(value.startsWith("byid.")){
            subValues = value.split("byid.");
            value = subValues[1];
            target = By.id(value);
            LOGGER.debug("The location mode is by id and final value is: " + value);
        }else if(value.startsWith("byname.")){
            subValues = value.split("byname.");
            value = subValues[1];
            target = By.name(value);
            LOGGER.debug("The location mode is by name and final value is: " + value);
        }else if(value.startsWith("bycss.")){
            subValues = value.split("bycss.");
            value = subValues[1];
            target = By.cssSelector(value);
            LOGGER.debug("The location mode is by css and final value is: " + value);
        }
        return target;
    }
}

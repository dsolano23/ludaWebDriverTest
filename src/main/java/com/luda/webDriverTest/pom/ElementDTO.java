package com.luda.webDriverTest.pom;

import org.openqa.selenium.By;

public class ElementDTO {


    private String elementKey;
    private By idElement;
    private String type;
    private String classAtr;
    private String text;
    private String placeholder;

    public ElementDTO(String elementKey, By idElement, String elementType) {
        this.elementKey = elementKey;
        this.idElement = idElement;
        this.type = elementType;
        this.classAtr = "";
        this.text = "";
        this.placeholder = "";
    }


    public String getElementKey() {
        return elementKey;
    }


    public By getIdElement() {
        return idElement;
    }


    public String getType() {
        return type;
    }


    public String getClassAtr() {
        return classAtr;
    }

    public void setClassAtr(String classAtr) {
        this.classAtr = classAtr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }



}

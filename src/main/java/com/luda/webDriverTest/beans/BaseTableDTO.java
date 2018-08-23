package com.luda.webDriverTest.beans;

public class BaseTableDTO {


    private String elementKey;
    private String xpathBase;
    private int firstRow;
    private String baseCurrentRow;
    private String mainSearchColumn;
    private String secondarySearchColumn;

    public BaseTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String mainSearchColumn) {
        this.elementKey = elementKey;
        this.xpathBase = xpathBase;
        this.firstRow = firstRow;
        this.baseCurrentRow = baseCurrentRow;
        this.mainSearchColumn = mainSearchColumn;
        this.secondarySearchColumn = "";
    }

    public BaseTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String mainSearchColumn, String secondarySearchColumn) {
        this.elementKey = elementKey;
        this.xpathBase = xpathBase;
        this.firstRow = firstRow;
        this.baseCurrentRow = baseCurrentRow;
        this.mainSearchColumn = mainSearchColumn;
        this.secondarySearchColumn = secondarySearchColumn;
    }

    public String getElementKey() {
        return elementKey;
    }

    public String getXpathBase() {
        return xpathBase;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public String getBaseCurrentRow() {
        return baseCurrentRow;
    }

    public String getMainSearchColumn() {
        return mainSearchColumn;
    }

    public String getSecondarySearchColumn() {
        return secondarySearchColumn;
    }
}

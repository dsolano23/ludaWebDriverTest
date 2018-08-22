package com.luda.webDriverTest.pom;

import org.openqa.selenium.By;

public class TableDTO {


    private String elementKey;
    private String xpathBase;
    private int firstRow;
    private String baseCurrentRow;
    private String columnDescriptionMolecule;
    private String columnDescription;
    private String columnFamily;
    private String columnPrescription;
    private String columnActions;
    private String columnAmount;


    public TableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String columnDescriptionMolecule, String columnDescription) {
        this.elementKey = elementKey;
        this.xpathBase = xpathBase;
        this.firstRow = firstRow;
        this.baseCurrentRow = baseCurrentRow;
        this.columnDescriptionMolecule = columnDescriptionMolecule;
        this.columnDescription = columnDescription;
        this.columnFamily = "";
        this.columnPrescription = "";
        this.columnActions = "";
        this.columnAmount = "";
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

    public String getColumnDescriptionMolecule() {
        return columnDescriptionMolecule;
    }

    public String getColumnDescription() {
        return columnDescription;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public String getColumnPrescription() {
        return columnPrescription;
    }

    public String getColumnActions() {
        return columnActions;
    }

    public String getColumnAmount() {
        return columnAmount;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }

    public void setColumnPrescription(String columnPrescription) {
        this.columnPrescription = columnPrescription;
    }

    public void setColumnActions(String columnActions) {
        this.columnActions = columnActions;
    }

    public void setColumnAmount(String columnAmount) {
        this.columnAmount = columnAmount;
    }

}

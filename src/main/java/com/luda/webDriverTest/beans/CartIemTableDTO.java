package com.luda.webDriverTest.beans;

public class CartIemTableDTO extends BaseTableDTO {


    private String columnActions;

    public CartIemTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String itemDescriptionMolecule, String itemDescription, String columnActions) {
        super(elementKey, xpathBase, firstRow, baseCurrentRow, itemDescriptionMolecule, itemDescription);
        this.columnActions = columnActions;
    }

    public String getItemDescriptionMolecule (){
        return this.getMainSearchColumn();
    }

    public String getItemDescription(){
        return this.getSecondarySearchColumn();
    }

    public String getColumnActions() {
        return columnActions;
    }

}

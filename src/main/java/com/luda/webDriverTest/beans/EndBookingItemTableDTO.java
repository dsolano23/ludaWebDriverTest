package com.luda.webDriverTest.beans;

public class EndBookingItemTableDTO extends BaseTableDTO {

    private String columnAmount;

    public EndBookingItemTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String itemDescriptionMolecule, String columnAmount) {
        super(elementKey, xpathBase, firstRow, baseCurrentRow, itemDescriptionMolecule);
        this.columnAmount = columnAmount;
    }

    public String getItemDescriptionMolecule(){
        return this.getMainSearchColumn();
    }

    public String getColumnAmount() {
        return columnAmount;
    }

}

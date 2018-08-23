package com.luda.webDriverTest.beans;

public class EndBookingPharmacyTableDTO extends BaseTableDTO {

    private String columnPharmacyAddress;

    public EndBookingPharmacyTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String columnPharmacyName, String columnPharmacyAddress) {
        super(elementKey, xpathBase, firstRow, baseCurrentRow, columnPharmacyName);
        this.columnPharmacyAddress = columnPharmacyAddress;
    }

    public String getColumnPharmacyName() {
        return this.getMainSearchColumn();
    }

    public String getColumnPharmacyAddress() {
        return columnPharmacyAddress;
    }

}

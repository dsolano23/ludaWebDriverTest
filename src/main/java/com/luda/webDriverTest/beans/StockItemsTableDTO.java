package com.luda.webDriverTest.beans;

public class StockItemsTableDTO extends BaseTableDTO {

    private String columnFamily;
    private String columnPrescription;
    private String columnActions;

    public StockItemsTableDTO(String elementKey, String xpathBase, int firstRow, String baseCurrentRow, String itemDescription, String columnFamily, String columnPrescription, String columnActions) {
        super(elementKey, xpathBase, firstRow, baseCurrentRow, itemDescription);
        this.columnFamily = columnFamily;
        this.columnPrescription = columnPrescription;
        this.columnActions = columnActions;
    }

    public String getColumnItemDescription() {
        return this.getMainSearchColumn();
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

}

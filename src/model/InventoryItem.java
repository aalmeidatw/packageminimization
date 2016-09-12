package model;

import lombok.Value;

@Value
public class InventoryItem implements Comparable<InventoryItem> {
    private String country;
    private String productName;
    private int quantity;

    @Override
    public int compareTo(InventoryItem inventoryItem) {
        return country.compareTo(inventoryItem.getProductName());
    }
}

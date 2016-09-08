package model;


import lombok.Builder;
import lombok.Value;

@Value
public class InventoryItem {
    private String country;
    private String productName;
    private int quantity;
}

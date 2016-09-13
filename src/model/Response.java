package model;

import lombok.Getter;
import lombok.Value;

import java.util.List;
@Getter
@Value
public class Response {
    private List<InventoryItem> inventoryItems;
    private int numberOfPackage;

    public Response(List<InventoryItem> inventoryItems, int numberOfPackage) {
        this.inventoryItems = inventoryItems;
        this.numberOfPackage = numberOfPackage;
    }
}


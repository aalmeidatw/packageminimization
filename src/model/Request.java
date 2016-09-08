package model;


import lombok.Value;

import java.util.List;

@Value
public class Request {
    private List<InventoryItem> inventoryItemList;
    private List<OrderItem> orderItemList;
}

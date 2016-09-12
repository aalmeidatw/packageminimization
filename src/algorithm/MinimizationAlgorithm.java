package algorithm;

import model.InventoryItem;
import model.OrderItem;
import java.util.*;
import java.util.stream.Collectors;

public class MinimizationAlgorithm {

    public List<InventoryItem> execute(List<InventoryItem> inventoryList, List<OrderItem> orderList) {

        Map<String, Integer> requestListMap = orderList
                .stream()
                .collect(Collectors.toMap(OrderItem::getProductName, OrderItem::getQuantity));

        List<InventoryItem> shipping = new ArrayList<>();

        for (OrderItem item : orderList) {

            for (InventoryItem inventory : inventoryList) {

                if (inventory.getProductName().equals(item.getProductName()) && (requestListMap.get(item.getProductName()) > 0)) {
                    if (item.getQuantity() == inventory.getQuantity()){
                        shipping.add(inventory);
                        requestListMap.put(item.getProductName(),0);
                    }
                }
            }
        }
        return shipping;
    }

}






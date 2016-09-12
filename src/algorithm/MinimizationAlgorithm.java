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

                if (isSameProductNameAndQuantityNeededIsMoreThanZero(requestListMap, item, inventory)) {
                    if (item.getQuantity() == inventory.getQuantity()){
                        shipping.add(inventory);
                        requestListMap.put(item.getProductName(),0);
                    }
                }
            }
        }
        return shipping;
    }

    private boolean isSameProductNameAndQuantityNeededIsMoreThanZero(Map<String, Integer> requestListMap, OrderItem item, InventoryItem inventory) {
        return inventory.getProductName().equals(item.getProductName()) && (requestListMap.get(item.getProductName()) > 0);
    }

}






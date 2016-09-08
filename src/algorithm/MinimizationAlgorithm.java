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

                if (inventory.getProductName().equals(item.getProductName())) {

                    if (requestListMap.get(item.getProductName()) > 0) {

                        int newQuantity = quantityCalculate(requestListMap.get(item.getProductName()), inventory.getQuantity());

                        requestListMap.put(item.getProductName(), newQuantity);
                        shipping.add(inventory);
                    }
                }
            }
        }
        return shipping;
    }


    public int quantityCalculate(int requestQuantity, int inventoryQuantity){

        if (inventoryQuantity >= requestQuantity){
            return 0;
        }

        return requestQuantity - inventoryQuantity;
    }



}






package algorithm;


import model.InventoryItem;
import model.OrderItem;
import model.Response;
import java.util.*;
import java.util.stream.Collectors;

public class MinimizationAlgorithm {

    public Response execute(List<InventoryItem> inventoryList, List<OrderItem> orderList) {

        Map<String, Integer> requestListMap = orderList
                .stream()
                .collect(Collectors.toMap(OrderItem::getProductName, OrderItem::getQuantity));

        List<InventoryItem> shipping = new ArrayList<>();

        for (OrderItem item : orderList) {

            for (InventoryItem inventory : inventoryList) {

                if (isSameProductNameAndQuantityNeededIsMoreThanZero(requestListMap, item, inventory)) {

                    int minValue = Math.min(requestListMap.get(item.getProductName()), inventory.getQuantity() );
                    int neededQuantity = requestListMap.get(item.getProductName()) - inventory.getQuantity();

                    insertNewValueInRequestMap(requestListMap, item, Math.max(0, neededQuantity));
                    shipping.add(new InventoryItem(inventory.getCountry(), inventory.getProductName(), minValue));
                }
            }
        }
        return new Response(shipping,getNumberOfPackage(shipping));
    }

    private int getNumberOfPackage(List<InventoryItem> shipping){
        Long  numberOfPackage = shipping.stream()
                             .map(InventoryItem::getCountry)
                             .distinct()
                             .count();
        return numberOfPackage.intValue();
    }

    private void insertNewValueInRequestMap(Map<String, Integer> requestListMap, OrderItem item, int value) {
        requestListMap.put(item.getProductName(), value);
    }

    private boolean isSameProductNameAndQuantityNeededIsMoreThanZero(Map<String, Integer> requestListMap, OrderItem item, InventoryItem inventory) {
        return inventory.getProductName().equals(item.getProductName()) && (requestListMap.get(item.getProductName()) > 0);
    }
}






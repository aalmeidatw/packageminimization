package algorithm;
import model.InventoryItem;
import model.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimizationAlgorithm {

    public void execute(List<InventoryItem> inventoryList, List<OrderItem> orderList) {

            findShipping(inventoryList, orderList, createRequestListMap(orderList));
    }

    public List<InventoryItem> findShipping(List<InventoryItem> inventoryList,
                                            List<OrderItem> orderList,
                                            HashMap<String, Integer> requestListMap ){

        List<InventoryItem> shipping = new ArrayList<>();

        for (OrderItem item : orderList) {
            for (InventoryItem inventory: inventoryList) {
                if (inventory.getProductName().equals(item.getProductName())){
                    if(requestListMap.get(item.getProductName()) > 0 ){

                        int newQuantity = requestListMap.get(item.getProductName()) - inventory.getQuantity();
                        requestListMap.put( item.getProductName(), newQuantity);
                        shipping.add(inventory);
                    }
                }
            }
        }
        return shipping;
    }


    public HashMap<String, Integer> createRequestListMap(List<OrderItem> orderItemList){

        HashMap<String, Integer> requestList = new HashMap<>();

        for (OrderItem item: orderItemList) {
            requestList.put(item.getProductName(), item.getQuantity());
        }
        return requestList;
    }

}



package app;

import algorithm.MinimizationAlgorithm;
import model.InventoryItem;
import model.OrderItem;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;
    private List<OrderItem> orderItemList;
    private List<InventoryItem> inventoryList;
    private static final String MOUSE_NAME= "Mouse";
    private static final String KEYBOARD_NAME= "Keyboard";
    private static final int MOUSE_QUANTITY = 2;
    private static final int KEYBOARD_QUANTITY = 3;
    private static final String BRAZIL_COUNTRY = "Brazil";
    private static final String ARGENTINA_COUNTRY = "Argentina";

    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
        this.orderItemList = new ArrayList<>();
        this.inventoryList = new ArrayList<>();

        orderItemList.add(new OrderItem(MOUSE_NAME, MOUSE_QUANTITY));
        orderItemList.add(new OrderItem(KEYBOARD_NAME, KEYBOARD_QUANTITY));
    }


    @Test
    public void shouldReturnListOfCountriesResponse() throws Exception {

        inventoryList.add(new InventoryItem(ARGENTINA_COUNTRY, KEYBOARD_NAME, KEYBOARD_QUANTITY));
        inventoryList.add(new InventoryItem(BRAZIL_COUNTRY, MOUSE_NAME, MOUSE_QUANTITY));

        HashMap<String, Integer> requestList = new HashMap<>();
        requestList.put(MOUSE_NAME, MOUSE_QUANTITY);
        requestList.put(KEYBOARD_NAME, KEYBOARD_QUANTITY);

        List<InventoryItem> expected = minimizationAlgorithm.findShipping(inventoryList, orderItemList, requestList );
        assertThat(expected.get(0).getCountry(), is(BRAZIL_COUNTRY));
        assertThat(expected.get(1).getCountry(), is(ARGENTINA_COUNTRY));
    }
}









package app;

import algorithm.MinimizationAlgorithm;
import model.InventoryItem;
import model.OrderItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;
    private final InventoryItem BRAZIL_ITEM = new InventoryItem("Brazil", "Mouse", 2);
    private final InventoryItem CHILE_ITEM = new InventoryItem("Chile", "Keyboard", 3);
    private final InventoryItem ARGENTINA_ITEM = new InventoryItem("Argentina", "Monitor", 6);
    private final OrderItem MOUSE_PRODUCT = new OrderItem("Mouse", 2);
    private final OrderItem MONITOR_PRODUCT = new OrderItem("Monitor", 6);

    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
    }

    @Test
    public void shouldReturnBrazilCountryWhenMouseProductIsPassed() throws Exception {
        List<InventoryItem> actual = minimizationAlgorithm.execute(asList(BRAZIL_ITEM, CHILE_ITEM), asList(MOUSE_PRODUCT));
        List<InventoryItem> expected = asList(BRAZIL_ITEM);

        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnBrazilAndArgentinaCountriesWhenMouseAndMonitorProductsIsPassed() throws Exception {
        List<InventoryItem> actual = minimizationAlgorithm.execute(asList(BRAZIL_ITEM, CHILE_ITEM, ARGENTINA_ITEM), asList(MOUSE_PRODUCT, MONITOR_PRODUCT));
        List<InventoryItem> expected = asList(BRAZIL_ITEM, ARGENTINA_ITEM);

        assertThat(actual, is(expected));
    }

    @Test
    public void testScenario1() throws Exception {
        List<InventoryItem> inventoryItemsList = asList(new InventoryItem("Brazil", "Keyboard", 2),
                new InventoryItem("Brazil", "Mouse", 1),
                new InventoryItem("Argentina", "Mouse", 2));

        List<InventoryItem> actual = minimizationAlgorithm.execute(inventoryItemsList,
                asList(new OrderItem("Keyboard", 2)));

        List<InventoryItem> expected = asList(new InventoryItem("Brazil", "Keyboard", 2));
        assertThat(actual, is(expected));
    }

    @Test
    public void testScenario2() throws Exception {

        List<InventoryItem> inventoryItemsList = asList(new InventoryItem("Brazil", "Keyboard", 2),
                new InventoryItem("Brazil", "Mouse", 1),
                new InventoryItem("Argentina", "Mouse", 2));

        List<OrderItem> orderItemList = asList(new OrderItem("Keyboard", 2), new OrderItem("Mouse", 1));

        List<InventoryItem> actual = minimizationAlgorithm.execute(inventoryItemsList,
                orderItemList);

        List<InventoryItem> expected = asList(new InventoryItem("Brazil", "Keyboard", 2),
                new InventoryItem("Brazil", "Mouse", 1));

        assertThat(actual, is(expected));
    }

    @Test
    public void testScenario3() throws Exception {
        List<InventoryItem> inventoryItemList = asList( new InventoryItem("Brazil", "Keyboard", 2),
                new InventoryItem("Brazil", "Mouse", 1),
                new InventoryItem("Brazil", "Monitor", 1),
                new InventoryItem("Chile", "Keyboard", 2),
                new InventoryItem("Chile", "Monitor", 2),
                new InventoryItem("Panama", "Mouse", 2),
                new InventoryItem("Argentina", "Monitor", 2));

        List<OrderItem> orderItemList = asList( new OrderItem("Keyboard", 3),
                new OrderItem("Mouse", 1),
                new OrderItem("Monitor", 2));

        List<InventoryItem> actual = minimizationAlgorithm.execute(inventoryItemList, orderItemList);

        List<InventoryItem> inventoryExpectedItemsList = asList(new InventoryItem("Brazil", "Keyboard", 2),
                new InventoryItem("Chile", "Keyboard", 1),
                new InventoryItem("Brazil", "Mouse", 1),
                new InventoryItem("Brazil", "Monitor", 1),
                new InventoryItem("Chile", "Monitor", 1));

        assertThat(actual, is(inventoryExpectedItemsList));
    }
}









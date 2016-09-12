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
        List<InventoryItem> expected = asList(ARGENTINA_ITEM, BRAZIL_ITEM);

        assertThat(actual, is(expected));
    }


    @Test
    public void testScenario3() throws Exception {
        InventoryItem brazilKeyboard = new InventoryItem("Brazil", "Keyboard", 2);
        InventoryItem brazilMouse = new InventoryItem("Brazil", "Mouse", 1);
        InventoryItem brazilMonitor = new InventoryItem("Brazil", "Monitor", 1);

        InventoryItem chileKeyboard = new InventoryItem("Chile", "Keyboard", 2);
        InventoryItem chileMonitor = new InventoryItem("Chile", "Monitor", 2);

        InventoryItem panamaMouse = new InventoryItem("Panama", "Mouse", 2);

        InventoryItem argentinaMonitor = new InventoryItem("Argentina", "Monitor", 2);

        OrderItem keyboardProduct = new OrderItem("Keyboard", 3);
        OrderItem mouseProduct = new OrderItem("Mouse", 1);
        OrderItem monitorProduct = new OrderItem("Monitor", 2);

        List<InventoryItem> actual = minimizationAlgorithm.execute(asList(brazilKeyboard,
                                                                          brazilMouse,
                                                                          brazilMonitor,
                                                                          chileKeyboard,
                                                                          chileMonitor,
                                                                          panamaMouse,
                                                                          argentinaMonitor),
                                    asList(keyboardProduct, mouseProduct, monitorProduct));

        InventoryItem brazilKeyboardExpected = new InventoryItem("Brazil", "Keyboard", 2);
        InventoryItem chileKeyboardExpected = new InventoryItem("Chile", "Keyboard", 1);
        InventoryItem brazilMouseExpected = new InventoryItem("Brazil", "Mouse", 1);
        InventoryItem brazilMonitorExpected = new InventoryItem("Brazil", "Monitor", 1);
        InventoryItem chileMonitorExpected = new InventoryItem("Chile", "Monitor", 1);

        List<InventoryItem> expected = asList(brazilKeyboardExpected,
                                              chileKeyboardExpected,
                                              brazilMouseExpected,
                                              brazilMonitorExpected,
                                              chileMonitorExpected);

        assertThat(actual, is(expected));
    }
}









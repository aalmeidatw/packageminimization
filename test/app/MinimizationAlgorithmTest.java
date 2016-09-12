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
}









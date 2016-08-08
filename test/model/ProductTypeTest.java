package model;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductTypeTest {
    private static final String KEYBOARD_PRODUCT = "KEYBOARD";
    private static final String MOUSE_PRODUCT = "MOUSE";
    private static final String MONITOR_PRODUCT = "MONITOR";
    private static final String NOT_PRODUCT = "CAR";


    @Test
    public void shouldReturnTrueWhenKeyBoardAsProduct() throws Exception {
        assertTrue(ProductType.isProduct(KEYBOARD_PRODUCT));
    }

    @Test
    public void shouldReturnTrueWhenMouseAsProduct() throws Exception {
        assertTrue(ProductType.isProduct(MOUSE_PRODUCT));
    }

    @Test
    public void shouldReturnTrueWhenMonitorAsProduct() throws Exception {
        assertTrue(ProductType.isProduct(MONITOR_PRODUCT));
    }

    @Test
    public void shouldReturnFalseWhenisNotProduct() throws Exception {
        assertFalse(ProductType.isProduct(NOT_PRODUCT));
    }
}
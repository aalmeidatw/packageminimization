package io;


import exception.FileErrorException;
import model.InventoryItem;
import model.OrderItem;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser;
    private final String FILE_ADDRESS = "src/resource/file.txt";
    private final String ERROR_FILE_ADDRESS = "src/resource/fil.txt";
    private List<InventoryItem> inventoryItemList;
    private List<OrderItem> orderItemList;
    private final String BRAZIL_NAME = "Brazil";
    private final String KEYBOARD_NAME = "Keyboard";

    @Before
    public void setUp() throws Exception {
        this.parser = new Parser();
        this.inventoryItemList = new ArrayList<>();
        this.orderItemList = new ArrayList<>();
    }

    @Test (expected = FileErrorException.class)
    public void shouldThrowExceptionWhenFileIsNotFound() throws Exception {
        parser.readFile(ERROR_FILE_ADDRESS);
    }

    @Test ()
    public void shouldCreateInventoryList() throws Exception {
        List[] expected  = parser.readFile(FILE_ADDRESS);
        this.inventoryItemList = expected[0];

        assertThat(inventoryItemList.get(0).getCountry(), is (BRAZIL_NAME));
    }

    @Test ()
    public void shouldCreateOrderList() throws Exception {
        List[] expected  = parser.readFile(FILE_ADDRESS);
        this.orderItemList = expected[1];

        assertThat(orderItemList.get(0).getProductName(), is (KEYBOARD_NAME));
    }
}
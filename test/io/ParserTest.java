package io;

import exception.FileErrorException;
import model.InventoryItem;
import model.OrderItem;
import model.Request;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParserTest {
    private Parser parser;
    private final String FILE_ADDRESS = "src/resource/testCase1.txt";
    private final String ERROR_FILE_ADDRESS = "src/resource/fil.txt";
    private final InventoryItem BRAZIL_ITEM = new InventoryItem("Brazil", "Mouse", 2);
    private final InventoryItem CHINE_ITEM = new InventoryItem("Chile", "Keyboard", 3);
    private final OrderItem KEYBOARD_PRODUCT = new OrderItem("Keyboard", 2);

    @Before
    public void setUp() throws Exception {
        this.parser = new Parser();
    }

    @Test (expected = FileErrorException.class)
    public void shouldThrowExceptionWhenFileIsNotFound() throws Exception {
        parser.readFile(ERROR_FILE_ADDRESS);
    }

    @Test
    public void shouldCreateRequestList() throws Exception {
        Request actual = parser.readFile(FILE_ADDRESS);
        Request expected = new Request(asList(BRAZIL_ITEM, CHINE_ITEM), asList(KEYBOARD_PRODUCT));

        assertThat(actual, is(expected));
    }
}
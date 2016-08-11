package io;

import exception.FileErrorException;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ParserTest {
    private Parser parser;
    private final String FILE_ADDRESS = "src/resource/file.txt";
    private final String ERROR_FILE_ADDRESS = "src/resource/fil.txt";

    @Before
    public void setUp() throws Exception {
        this.parser = new Parser();
    }

    @Test
    public void shouldReturnArrayAsInputFile() throws Exception {
        List<String> inputArray = parser.readFile(FILE_ADDRESS);
        assertThat(inputArray.get(0), is("Brazil"));
    }

    @Test (expected = FileErrorException.class)
    public void shouldThrowExceptionWhenFileIsNotFound() throws Exception {
        parser.readFile(ERROR_FILE_ADDRESS);
    }
}
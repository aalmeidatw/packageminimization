package io;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ParserTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        this.parser = new Parser();
    }

    @Test
    public void shouldReturnArrayAsInputFile() throws Exception {
        List<String> inputArray = parser.readFile();
        assertThat(inputArray.get(0), is("Brazil"));
    }
}
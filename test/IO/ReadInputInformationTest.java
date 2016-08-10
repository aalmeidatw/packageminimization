package io;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ReadInputInformationTest {
    private ReadInputInformation readInputInformation;

    @Before
    public void setUp() throws Exception {
        this.readInputInformation = new ReadInputInformation();
    }

    @Test
    public void shouldReturnArrayAsInputFile() throws Exception {
        List<String> inputArray = readInputInformation.readFile();
        assertThat(inputArray.get(0), is("Brazil Mouse 1"));
    }
}
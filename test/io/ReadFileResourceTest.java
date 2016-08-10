package io;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ReadFileResourceTest {
    private ReadFileResource readFileResource;

    @Before
    public void setUp() throws Exception {
        this.readFileResource = new ReadFileResource();
    }

    @Test
    public void shouldReturnArrayAsInputFile() throws Exception {
        List<String> inputArray = readFileResource.readFile();
        assertThat(inputArray.get(0), is("Brazil Mouse 1"));
    }
}
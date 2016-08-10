package parse;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserTest {
    private Parser parseInput;

    @Before
    public void setUp() throws Exception {
        this.parseInput = new Parser();
    }

    @Test
    public void shouldReturnArrayOfUserInput() throws Exception {
        List<String> inputArray = new ArrayList<>();
        List<String> expectedInputArray;

        inputArray.add("Brazil Mouse 1");
        inputArray.add("Argentina Mouse 2");
        inputArray.add("Keyboard 2");

        expectedInputArray = parseInput.parseInputArray(inputArray);
        assertThat(expectedInputArray.get(0), is("Brazil"));
        assertThat(expectedInputArray.get(3), is("Argentina"));
    }

}
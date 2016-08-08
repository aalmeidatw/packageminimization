package app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;


    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
    }

    @Test
    public void shouldReturnBrazilStringWhenFirtsCountryAsFound() throws Exception {
        assertThat(minimizationAlgorithm.execute(createUserInput()), is("Brazil"));

    }

    private List<String> createUserInput(){
        List<String> inputArray = new ArrayList<>();

        inputArray.add("Brazil");
        inputArray.add("Mouse");
        inputArray.add("2");

        return inputArray;
    }

}
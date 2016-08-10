package app;

import list.ListOfCountry;
import model.Country;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;
    private static final String  PRODUCT_NAME = "Mouse";
    private static final int  PRODUCT_AMOUNT = 2;
    private static final String BRAZIL_NAME = "Brazil";
    private Country brazilCountry;
    private ListOfCountry listOfCountry;



    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
        this.brazilCountry = new Country(BRAZIL_NAME);
        this.listOfCountry = new ListOfCountry();
    }

    @Test
    public void shouldAddItemToCountry() throws Exception {
        listOfCountry.addToCountriesList(brazilCountry);
        minimizationAlgorithm.execute(createUserInput(), listOfCountry);
       assertThat(listOfCountry.getProductAmount(brazilCountry, PRODUCT_NAME), is(PRODUCT_AMOUNT));

    }

    @Test
    public void shouldReturnIndexWhenProductAsFound() throws Exception {
        assertThat(minimizationAlgorithm.getIndexOfInput(PRODUCT_NAME, createUserInput()), is(1));
}

    private List<String> createUserInput(){
        List<String> inputArray = new ArrayList<>();

        inputArray.add("Brazil");
        inputArray.add("Mouse");
        inputArray.add("2");

        return inputArray;
    }

}
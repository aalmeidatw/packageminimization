package app;

import algorithm.MinimizationAlgorithm;
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

}
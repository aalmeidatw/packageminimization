package app;

import algorithm.MinimizationAlgorithm;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;
    private static final String BRAZIL_COUNTRY = "Brazil Mouse 1";
    private static final String CHILE_COUNTRY = "Chile keyboard 2";
    private static final String ARGENTINA_COUNTRY = "Argentina Mouse 2";
    private static final String MOUSE_REQUEST = "Mouse 2";
    private static final String MOUSE_NAME = "Mouse";
    private static final String PARSE_STRING = "First Second";


    private static final String KEYBOARD_REQUEST = "keyboard 3";


    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
    }

    @Test
    public void shouldAddBrazilCountry() throws Exception {
        minimizationAlgorithm.addCountry(BRAZIL_COUNTRY);
        minimizationAlgorithm.addCountry(CHILE_COUNTRY);

        List<String> list = minimizationAlgorithm.getCountryList();
        assertThat(getInfo(list,0,0 ),is ("Brazil") );
    }

    @Test
    public void shouldAddChileCountry() throws Exception {
        minimizationAlgorithm.addCountry(BRAZIL_COUNTRY);
        minimizationAlgorithm.addCountry(CHILE_COUNTRY);

        List<String> list = minimizationAlgorithm.getCountryList();
        assertThat(getInfo(list,1,0),is ("Chile") );
    }

    @Test
    public void shouldAddMouseRequest() throws Exception {
        minimizationAlgorithm.addIRequestList(MOUSE_REQUEST);

        List<String> list = minimizationAlgorithm.getRequestList();
        assertThat(getInfo(list,0,0),is ("Mouse") );
    }

    @Test
    public void shouldAddKeyboardRequest() throws Exception {
        minimizationAlgorithm.addIRequestList(MOUSE_REQUEST);
        minimizationAlgorithm.addIRequestList(KEYBOARD_REQUEST);

        List<String> list = minimizationAlgorithm.getRequestList();
        assertThat(getInfo(list,1,0),is ("keyboard") );
    }

    @Test
    public void shouldCreateCountryListThatHaveMouseProductIsPassed() throws Exception {
        minimizationAlgorithm.addCountry(BRAZIL_COUNTRY);
        minimizationAlgorithm.addCountry(CHILE_COUNTRY);
        minimizationAlgorithm.addCountry(ARGENTINA_COUNTRY);

        minimizationAlgorithm.createCountryListThatHaveProduct(MOUSE_NAME);

        List<String> list = minimizationAlgorithm.getCountryAvailableList();
        assertThat(getInfo(list,0,0),is ("Brazil") );
        assertThat(getInfo(list,1,0),is ("Argentina") );

    }

    @Test
    public void shouldReturnFirstWordOfStringPassed() throws Exception {
        assertThat(minimizationAlgorithm.getParseInfo(PARSE_STRING, 0), is ("First"));
    }

    @Test
    public void shouldReturnSecondWordOfStringPassed() throws Exception {
        assertThat(minimizationAlgorithm.getParseInfo(PARSE_STRING, 1), is ("Second"));
    }

    private String getInfo(List<String> list, int indexArray, int position){
        String[] line =list.get(indexArray).split(" ");
        return line[position];
    }

}









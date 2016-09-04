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
    private static final String PARSE_STRING = "First Second";
    private static final String KEYBOARD_REQUEST = "keyboard 2";


    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
        minimizationAlgorithm.addCountry(BRAZIL_COUNTRY);
        minimizationAlgorithm.addCountry(CHILE_COUNTRY);
        minimizationAlgorithm.addCountry(ARGENTINA_COUNTRY);
    }

    @Test
    public void shouldAddBrazilCountry() throws Exception {
        List<String> list = minimizationAlgorithm.getCountryList();
        assertThat(getInfo(list,0,0 ),is ("Brazil") );
    }

    @Test
    public void shouldAddChileCountry() throws Exception {
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
    public void shouldCreateCountryListThatHaveMouseProductPassed() throws Exception {
        minimizationAlgorithm.addIRequestList(MOUSE_REQUEST);
        minimizationAlgorithm.sendRequestItemsToCreateCountryList();

        List<String> list = minimizationAlgorithm.getCountryAvailableList();

        assertThat(getInfo(list,0,0), is ("Brazil"));
        assertThat(getInfo(list,1,0), is ("Argentina"));
    }

    @Test
    public void shouldReturnFirstWordOfStringPassed() throws Exception {
        assertThat(minimizationAlgorithm.getParseInfo(PARSE_STRING, 0), is ("First"));
    }

    @Test
    public void shouldReturnSecondWordOfStringPassed() throws Exception {
        assertThat(minimizationAlgorithm.getParseInfo(PARSE_STRING, 1), is ("Second"));
    }

    @Test
    public void shouldReturnChileCountryWhenKeyBoardRequestIsPassed() throws Exception {
        minimizationAlgorithm.addIRequestList(KEYBOARD_REQUEST);
        minimizationAlgorithm.sendRequestItemsToCreateCountryList();
        assertThat(minimizationAlgorithm.findCountry("keyboard", 2), is(CHILE_COUNTRY));
    }

    @Test
    public void shouldReturnArrayThanOneCountry() throws Exception {
        minimizationAlgorithm.addIRequestList(KEYBOARD_REQUEST);
        minimizationAlgorithm.sendRequestItemsToCreateCountryList();
        List<String> response = minimizationAlgorithm.execute();
        System.out.print(response.get(1).toString());

        assertThat(response.get(0), is("1"));
        assertThat(response.get(1), is(CHILE_COUNTRY));


    }

    private String getInfo(List<String> list, int indexArray, int position){
        String[] line =list.get(indexArray).split(" ");
        return line[position];
    }




}









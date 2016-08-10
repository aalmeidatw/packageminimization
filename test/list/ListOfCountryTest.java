package list;

import model.Country;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ListOfCountryTest {
    private ListOfCountry listOfCountry;
    private Country brazilCountry;
    private Country argentinaCountry;
    private static final int MOUSE_COUNT = 3;
    private static final String BRAZIL_NAME = "Brazil";
    private static final String ARGENTINA_NAME = "Argentina";
    private static final String SOME_COUNTRY = "England";
    private static final String MOUSE_ITEM = "Mouse";

    @Before
    public void setUp() throws Exception {

        this.brazilCountry = new Country(BRAZIL_NAME);
        this.brazilCountry.addItemInCountry(MOUSE_ITEM, MOUSE_COUNT);

        this.argentinaCountry = new Country(ARGENTINA_NAME);
        this.argentinaCountry.addItemInCountry(MOUSE_ITEM, MOUSE_COUNT);

        this.listOfCountry = new ListOfCountry();

        this.listOfCountry.addToCountriesList(brazilCountry);
        this.listOfCountry.addToCountriesList(argentinaCountry);
    }

    @Test
    public void shouldReturnTrueWhenCountryExistInArray() throws Exception {
         assertTrue(listOfCountry.isCountryExist(BRAZIL_NAME));
    }

    @Test
    public void shouldReturnFalseWhenCountryIsNotExistInArray() throws Exception {
        assertFalse(listOfCountry.isCountryExist(SOME_COUNTRY));
    }

    @Test
    public void shouldReturnProductAmountPassedACountry() throws Exception {
        assertThat(listOfCountry.getProductAmount(brazilCountry, MOUSE_ITEM), is(MOUSE_COUNT));

    }
}
package model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountryTest {
    private  Country country;
    private static final String COUNTRY_NAME = "SOME_NAME";
    private static final String ITEM_NAME = "SOME_ITEM";
    private static final String OTHER_NAME = "OTHER_ITEM";
    private static final int AMOUNT = 2;


    @Before
    public void setUp() throws Exception {
        this.country = new Country(COUNTRY_NAME);
        country.addItem(ITEM_NAME, AMOUNT);
    }

    @Test
    public void shouldReturnCountryName() throws Exception {
        assertThat(country.getCountryName(), is(COUNTRY_NAME));
    }

    @Test
    public void shouldReturnItemAmount() throws Exception {
        country.addItem(ITEM_NAME, AMOUNT);
        assertThat(country.getItemAmount(ITEM_NAME), is(2));
    }

    @Test
    public void shouldReturnTrueWhenIsAvailableProduct() throws Exception {
        assertTrue(country.isAvailableProduct(ITEM_NAME));
    }

    @Test
    public void shouldReturnFalseWhenProductIsNotAvailable() throws Exception {
        assertFalse(country.isAvailableProduct(OTHER_NAME));
    }
}
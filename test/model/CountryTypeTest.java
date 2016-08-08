package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountryTypeTest {
    private static final String BRAZIL_COUNTRY = "BRAZIL";
    private static final String CHILE_COUNTRY = "CHILE";
    private static final String PANAMA_COUNTRY = "PANAMA";
    private static final String ARGENTINA_COUNTRY = "ARGENTINA";
    private static final String NOT_COUNTRY = "TABLE";

    @Test
    public void shouldReturnTrueWhenBrazilIsACountry() throws Exception {
       assertTrue(CountryType.isCountry(BRAZIL_COUNTRY));
    }

    @Test
    public void shouldReturnTrueWhenChileIsACountry() throws Exception {
        assertTrue(CountryType.isCountry(CHILE_COUNTRY));
    }

    @Test
    public void shouldReturnTrueWhenPanamaIsACountry() throws Exception {
        assertTrue(CountryType.isCountry(PANAMA_COUNTRY));
    }

    @Test
    public void shouldReturnTrueWhenArgentinaIsACountry() throws Exception {
        assertTrue(CountryType.isCountry(ARGENTINA_COUNTRY));
    }

    @Test
    public void shouldReturnFalseWhenIsNotACountry() throws Exception {
        assertFalse(CountryType.isCountry(NOT_COUNTRY));
    }




}
package model;

public enum CountryType {

    BRAZIL, CHILE, PANAMA, ARGENTINA;


    public static boolean isCountry(String country) {

        String countryUpperCase = country.toUpperCase();

        return ((countryUpperCase.equals(BRAZIL.name())) ||
                (countryUpperCase.equals(CHILE.name())) ||
                (countryUpperCase.equals(PANAMA.name())) ||
                (countryUpperCase.equals(ARGENTINA.name())) );
     }
}






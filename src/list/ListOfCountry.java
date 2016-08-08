package list;


import model.Country;

import java.util.ArrayList;
import java.util.List;

public class ListOfCountry {
    private List<Country> countryList = new ArrayList<>();


    public boolean isCountryExist(String countryName){
        for (Country country: countryList) {
            if(country.getCountryName().equals(countryName)){
                return true;
            }
        }
        return false;
    }

    public boolean addToCountriesList(Country country){
        countryList.add(country);
        return true;
    }

}

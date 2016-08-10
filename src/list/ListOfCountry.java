package list;


import model.Country;

import java.util.ArrayList;
import java.util.List;

public class ListOfCountry {
    private List<Country> countryList = new ArrayList<>();


    public boolean isCountryExist(String countryName){
        for (Country country: countryList) {
            if(isEqualsCountry(countryName, country)){
                return true;
            }
        }
        return false;
    }

    public boolean addToCountriesList(Country country){
        countryList.add(country);
        return true;
    }

    public void addItemToCountry(String countryName, String productName, int amount){

        for (Country country: countryList) {
            if(isEqualsCountry(countryName, country)){
                country.addItemInCountry(productName, amount);
            }
        }

    }

    public int getProductAmount(Country country, String productName){
        return country.getItemAmount(productName);

    }

    private boolean isEqualsCountry(String countryName, Country country) {
        return country.getCountryName().equals(countryName);
    }


}

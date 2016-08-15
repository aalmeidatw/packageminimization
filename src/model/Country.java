package model;


import java.util.HashMap;

public class Country {
    private String countryName;
    private HashMap<String, Integer> countryItemList =  new HashMap<>();


    public Country(String countryName ) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }


    public void addItemInCountry(String productName, int amount){
        countryItemList.put(productName, amount);
    }

    public int getItemAmount(String product){
        return countryItemList.get(product);
    }
}

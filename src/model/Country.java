package model;


import java.util.HashMap;

public class Country {
    private String countryName;
    private HashMap<String, Integer> itemList = new HashMap<>();

    public Country(String countryName ) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public boolean addItemInCountry(String productName, int amount){
        itemList.put(productName, amount);
        return true;
    }

    public int getItemAmount(String product){
        return itemList.get(product);
    }
}

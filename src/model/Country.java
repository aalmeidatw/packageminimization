package model;


import java.util.HashMap;
import java.util.Map;

public class Country {
    private String countryName;
    private HashMap<String, Integer> countryItemList =  new HashMap<>();


    public Country(String countryName ) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void addItem(String productName, int amount){
        countryItemList.put(productName, amount);
    }

    public int getItemAmount(String product){
        return countryItemList.get(product);
    }

    public boolean isAvailableProduct(String productName){
        boolean isAvailableProduct = false;

        for (Map.Entry<String, Integer> item : countryItemList.entrySet() ){
            if(item.getKey().equals(productName)){
                isAvailableProduct = true;
            }
        }
        return isAvailableProduct;
    }


}

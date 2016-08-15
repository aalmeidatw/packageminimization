package algorithm;
import model.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MinimizationAlgorithm {
    private List<Country> countryList = new ArrayList<>();
    private HashMap<String, Integer> requestList =  new HashMap<>();


    private void execute (){
        //logic
    }



    public void addItemToCountry(String countryName, String product, int amount){

        for (Country country: countryList) {

            if(country.getCountryName().equals(countryName)){
                country.addItemInCountry(product, amount);
            } else {
                Country newCountry = new Country(countryName);
                newCountry.addItemInCountry(product, amount);
                countryList.add(newCountry);
            }
        }
    }

    public void addItemToRequestList(String productName, int productAmount){
        requestList.put(productName, productAmount);
    }

}

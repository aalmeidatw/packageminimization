package app;

import list.ListOfCountry;
import model.CountryType;
import java.util.List;


public class MinimizationAlgorithm {
    private ListOfCountry listOfCountry;


    public void execute(List<String> inputArray, ListOfCountry listOfCountry) {
        this.listOfCountry = listOfCountry;


        for (String input : inputArray) {

            if (CountryType.isCountry(input)) {
                if (listOfCountry.isCountryExist(input)) {
                   addItemToCountry(input,inputArray);
                }
            }
        }

    }

    private void addItemToCountry(String countryName, List<String> inputArray) {
        int productIndex = getIndexOfInput(countryName, inputArray) ;
        listOfCountry.addItemToCountry(countryName, inputArray.get(productIndex), productIndex + 1);
    }

    protected int getIndexOfInput(String input, List<String> inputArray ){
        int productIndex = 0;

            if(inputArray.contains(input)){
                productIndex = inputArray.indexOf(input);
            }
        return productIndex;
     }

}

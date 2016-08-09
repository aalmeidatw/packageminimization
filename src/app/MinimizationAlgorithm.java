package app;

import list.ListOfCountry;
import model.CountryType;
import java.util.List;


public class MinimizationAlgorithm {
    private ListOfCountry listOfCountry;


    public String execute(List<String> inputArray) {

        return "error";
    }



    protected int getIndexOfInput(String input, List<String> inputArray ){
        int productIndex = 0;

            if(inputArray.contains(input)){
                productIndex = inputArray.indexOf(input);
            }
        return productIndex;
     }



}

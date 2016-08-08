package app;

import model.CountryType;
import model.ProductType;
import parse.ParseInput;
import java.util.List;


public class MinimizationAlgorithm {

    private ParseInput parseInput;

    public String execute(List<String> inputArray){

        for (String input: inputArray) {
            if(CountryType.isCountry(input)){
                return input;
            }



        }
        return "error";

    }



}

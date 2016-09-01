package algorithm;
import java.util.ArrayList;
import java.util.List;

public class MinimizationAlgorithm {
    private List<String> countryList = new ArrayList<>();
    private List<String> countryAvailableList = new ArrayList<>();
    private List<String> requestList =  new ArrayList<>();


    public void execute (){

        String[] arr = {"A","B","C","D","E","F"};
        //combinations2(arr, 3, 0, new String[3]);







    }


    public void  createCountryListThatHaveProduct(String productRequest){

        for (String country: countryList) {

            String productName = getProductName(country);

            if (productName.equals(productRequest)){
                countryAvailableList.add(country);
            }
        }
     }

    private String getProductName(String country) {
        String[] line = country.split(" ");
        return line[1];
    }

    public List<String> getCountryList(){
        return countryList;
    }

    public List<String> getRequestList(){
        return requestList;
    }

    public List<String> getCountryAvailableList(){
        return countryAvailableList;
    }

    public void addCountry(String country){
        this.countryList.add(country);

    }

    public void addIRequestList(String request){
        requestList.add(request);
    }

}

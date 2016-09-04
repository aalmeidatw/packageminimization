package algorithm;
import java.util.ArrayList;
import java.util.List;

public class MinimizationAlgorithm {
    private List<String> countryList = new ArrayList<>();
    private List<String> countryAvailableList = new ArrayList<>();
    private List<String> requestList = new ArrayList<>();
    private List<String> response = new ArrayList<>();



    public List<String> execute() {
        String product;
        int quantity;



        // cria lista de paises que possuem o produto
        sendRequestItemsToCreateCountryList();






        for (String item : requestList) {
            product = getParseInfo(item, 0);
            quantity = Integer.parseInt(getParseInfo(item, 1));

            if (requestList.size() == 1){
                response.add(String.valueOf(1));
                response.add(findCountry(product, quantity));
            }
        }




    return response;
    }


    public String findCountry(String productRequest, int quantityNeeded){
        String result = "";

        for (String country : countryAvailableList) {

            String product = getParseInfo(country, 1);

            int quantity = Integer.parseInt(getParseInfo(country, 2));

            if(product.equals(productRequest) && (quantity == quantityNeeded)){
                result = country;
            }
        }
        return result;
    }


    public void sendRequestItemsToCreateCountryList(){

        for (String item : requestList) {
            String product = getParseInfo(item, 0);
            createCountryListThatHaveProduct(product);
        }
    }
   private void createCountryListThatHaveProduct(String productRequest) {

        for (String country : countryList) {

            String productName = getParseInfo(country, 1);

            if (productName.equals(productRequest)) {
                countryAvailableList.add(country);
            }
        }
    }


    public String getParseInfo(String inputLine, int position){
        String[] line = inputLine.split(" ");
        return line[position];
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public List<String> getRequestList() {
        return requestList;
    }

    public List<String> getCountryAvailableList() {
        return countryAvailableList;
    }

    public void addCountry(String country) {
        this.countryList.add(country);
    }

    public void addIRequestList(String request) {
        requestList.add(request);
    }
}

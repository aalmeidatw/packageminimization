package algorithm;
import java.util.ArrayList;
import java.util.List;

public class MinimizationAlgorithm {
    private List<String> countryList = new ArrayList<>();
    private List<String> countryAvailableList = new ArrayList<>();
    private List<String> requestList = new ArrayList<>();


    public void execute() {
    }


    public void createCountryListThatHaveProduct(String productRequest) {

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

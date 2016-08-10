package parse;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<String> arrayOfInput = new ArrayList<>();

    public List<String> parseInputArray(List<String> array){

        for (String inputUser : array) {
            String[] line = inputUser.split(" ");

            for (String value : line) {
                arrayOfInput.add(value);
            }
        }
        return arrayOfInput;
    }
}

package io;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadInputInformation {
    private List<String> inputArray = new ArrayList<>();
    private final String fileAddress = "src/resource/resource.txt";


    public List<String> readFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress));
            String line = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                this.inputArray.add(line);
             }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("resource not found");
        } catch (IOException ex) {
            System.out.println("Error  I/O");
        }

        return inputArray;
    }

}

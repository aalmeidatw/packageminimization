package io;


import exception.FileErrorException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadInputInformation {
    private List<String> inputArray = new ArrayList<>();
    private final String fileAddress = "src/resource/resource.txt";
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";


    public List<String> readFile() throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress));
            String line = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                this.inputArray.add(line);
             }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
                  throw new FileErrorException(FILE_NOT_FOUND_MESSAGE);
        }
        return inputArray;
    }

}

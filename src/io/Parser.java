package io;


import exception.FileErrorException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Parser {
    private List<String> inputArray = new ArrayList<>();
    private final String FILE_ADDRESS = "src/resource/file.txt";
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";


    public List<String> readFile() throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_ADDRESS));
            String line = bufferedReader.readLine();
            while (line != null) {

                line = bufferedReader.readLine();
                parseForArray(line);
            }
            bufferedReader.close();


        } catch (FileNotFoundException ex) {
                  throw new FileErrorException(FILE_NOT_FOUND_MESSAGE);
        }

        return inputArray;
    }

    private void parseForArray(String inputLine){

        if (inputLine != null) {
            String[] line = inputLine.split(" ");

            for (String value : line) {
                inputArray.add(value);
            }
        }
    }
}

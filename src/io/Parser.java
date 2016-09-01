package io;


import algorithm.MinimizationAlgorithm;
import exception.FileErrorException;
import model.Country;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Parser {
    private List<String> inputArray = new ArrayList<>();
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";
    private MinimizationAlgorithm minimizationAlgorithm;


    public List<String> readFile(String fileAddress) throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress));
            String line = bufferedReader.readLine();
            while (line != null) {

                line = bufferedReader.readLine();
                System.out.println(line);
                parseLine(line);
            }
            bufferedReader.close();

            } catch (FileNotFoundException ex) {
                throw new FileErrorException(FILE_NOT_FOUND_MESSAGE);
        }

        return inputArray;
    }

    private void parseLine(String inputLine){

        if (inputLine != null) {

            String[] line = inputLine.split(" ");

            if (isCountry(line)) {
                minimizationAlgorithm.addCountry(inputLine);

            } else {
                minimizationAlgorithm.addIRequestList(inputLine);
            }
        }
    }

    private boolean isCountry(String[] line){
        return line.length == 2;

    }


  /*  private void splitLine(String[] line){

        if (line.length == 2){
            this.countryName = line[0];
            this.productName = line[1];
            this.productAmount =  Integer.parseInt(line[2]);

        }else if (line.length == 1){
            this.productName = line[0];
            this.productAmount =  Integer.parseInt(line[1]);
        }
    }*/


}

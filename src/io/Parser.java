package io;


import algorithm.MinimizationAlgorithm;
import exception.FileErrorException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";
    private MinimizationAlgorithm minimizationAlgorithm;


    public Parser(MinimizationAlgorithm minimizationAlgorithm) {
        this.minimizationAlgorithm = minimizationAlgorithm;
    }

    public void readFile(String fileAddress) throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress));
            String line = bufferedReader.readLine();
            while (line != null) {

                line = bufferedReader.readLine();
                parseLine(line);
            }
            bufferedReader.close();

            } catch (FileNotFoundException ex) {
                throw new FileErrorException(FILE_NOT_FOUND_MESSAGE);
        }
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
        return line.length == 3;
    }
}

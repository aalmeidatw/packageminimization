package io;


import exception.FileErrorException;
import model.InventoryItem;
import model.OrderItem;
import model.Request;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";

    private List<InventoryItem> inventoryItemList = new ArrayList<>();
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Request readFile(String fileAddress) throws Exception {

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
        return new Request(inventoryItemList, orderItemList);
    }

    private void parseLine(String inputLine) {
        if (inputLine != null) {
            String[] line = inputLine.split(" ");

            if (line.length == 3) {
                inventoryItemList.add(new InventoryItem(line[0], line[1], Integer.parseInt(line[2])));
            } else if (line.length == 2) {
                orderItemList.add(new OrderItem(line[0], Integer.parseInt(line[1])));
            }
        }
    }
}

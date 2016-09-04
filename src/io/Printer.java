package io;


import java.util.List;

public class Printer {
    public static void print(int deliveryQuantity, List<String> list){

        System.out.println(deliveryQuantity);

        for (String country: list){
            System.out.print(country);
        }
    }
}

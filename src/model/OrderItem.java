package model;


import lombok.Value;

@Value
public class OrderItem {
    private String productName;
    private int quantity;
}

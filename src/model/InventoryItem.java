package model;


public class InventoryItem {
    private String country;
    private String productName;
    private int quantity;


    public InventoryItem(String country, String productName, int quantity) {
        this.country = country;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCountry() {
        return country;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

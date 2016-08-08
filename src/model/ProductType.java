package model;

public enum ProductType {

    KEYBOARD, MOUSE, MONITOR;

    public static boolean isProduct(String product) {

        String productUpperCase = product.toUpperCase();

        return ((productUpperCase.equals(KEYBOARD.name())) ||
                (productUpperCase.equals(MOUSE.name())) ||
                (productUpperCase.equals(MONITOR.name())) );
    }
}

package model;

public class Product {

    private int id;

    private String productName;

    private String description;

    private double price;

    private int discountPercent;

    private double totalPrice;

    private int stock;

    public Product(int id, String productName, String description, double price, int discountPercent, int stock) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.discountPercent = discountPercent;
        this.stock = stock;
        this.totalPrice = calculateTotalPrice();
    }
   public double calculateTotalPrice() {
        double discount = price * discountPercent / 100.0;
        return price - discount;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getDiscountPercent() {
        return discountPercent;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity){
        this.stock = this.stock-quantity;
    }
    @Override
    public String toString() {
        return id + ". " + productName + " - ₹" + price + " (" + discountPercent + "% off = ₹" + totalPrice + ") [" + stock + " left]\n" +
                "   → " + description;
    }

}

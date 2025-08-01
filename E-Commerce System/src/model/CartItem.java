package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartItem {

    private Product product;

    private int quantity;

    private double discountPercent;

    private LocalDateTime addedTime;

    public CartItem(Product product, int quantity, double discountPercent) {
        this.product = product;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
        this.addedTime = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getDiscountPercent() {
        return discountPercent;
    }
    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPriceBeforeDiscount() {
        return product.getPrice() * quantity;
    }

    public double getDiscountAmount() {
        return getTotalPriceBeforeDiscount() * (discountPercent / 100.0);
    }

    public double getFinalPrice() {
        return getTotalPriceBeforeDiscount() - getDiscountAmount();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return product.getProductName() + " x" + quantity + " @ ₹" + product.getPrice() + "\n" +
                "Added: " + formatter.format(addedTime) + "\n" +
                "Discount: " + discountPercent + "% (-₹" + getDiscountAmount() + ")\n" +
                "Total: ₹" + getFinalPrice() + "\n";
    }



}

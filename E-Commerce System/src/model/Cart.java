package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public void addItem(Product product,int quantity,double discountPercent){
        for (CartItem item : items){
            if (item.getProduct().getId() == product.getId()){
                item.setQuantity(item.getQuantity()+quantity);
                return;
            }
        }
        items.add(new CartItem(product,quantity,discountPercent));
    }

    public boolean removeItem(int productId){
        return items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public List<CartItem> getItems(){
        return items;
    }

    public double getTotalBeforDiscount(){
        return items.stream().mapToDouble(CartItem::getTotalPriceBeforeDiscount).sum();
    }

    public  double getTotalDiscount(){
       return items.stream()
               .mapToDouble(CartItem::getDiscountAmount)
               .sum();
    }

    public double getFinalTotal(){
        return getTotalBeforDiscount() -  getTotalDiscount();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clearCart(){
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "🛒 Cart is empty.";
        }

        StringBuilder sb = new StringBuilder("🛒 Cart Items:\n");
        for (CartItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total Before Discount: ₹").append(getTotalBeforDiscount()).append("\n");
        sb.append("Total Discount: -₹").append(getTotalDiscount()).append("\n");
        sb.append("Final Total: ₹").append(getFinalTotal()).append("\n");
        return sb.toString();
    }

}

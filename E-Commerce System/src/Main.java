  import model.CartItem;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static final List<CartItem> cartItems = new ArrayList<>();


    private static User loggedInUser = null;

    public static void main(String[] args) {

        seedData();
        System.out.println("====Welcome to Basic E-Commerce System====");

        boolean running = true;

        while (running){

            if (loggedInUser==null){
                System.out.println("/\n1. Register \n2. Login \n3 .Exit");
                System.out.println("Enter your Choice : ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice){

                    case 1 -> registerUser();
                    case 2 -> LoginUser();
                    case 3 -> {
                                 System.out.println("Thanks for visiting....");
                                   running = false;
                               }
                    default -> System.out.println("Invalid Choice");
                }
            }
            else {
                System.out.println("\n1. View Products \n2. View Cart \n3. Checkout \n4. Logout ");
                System.out.print("Enter your Choice : ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1-> showProducts();
                    case 2-> showCart();
                    case 3-> checkout();
                    case 4->{
                        loggedInUser =null;
                        cartItems.clear();;
                        System.out.println("Logged Out Successfully...");
                    }
                    default -> System.out.println("Invalid Choice..");
                }
            }
        }
    }


    private static void registerUser(){
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Email : ");
        String email = sc.nextLine();
        System.out.print("Enter Password : ");
        String password = sc.nextLine();
        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        users.add(new User(name,email,password,address));
        System.out.println("Registered Successfully...");

    }

    private static void LoginUser(){
        System.out.print("Enter email : ");
        String email = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();

        for (User user : users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful Welcome. " + user.getName() + "!");
                return;
            }
        }
        System.out.println("[ Invalid email or password ]");
    }

    private static void seedData(){
        products.add(new Product(1, "Shoes", "Comfortable running shoes", 2000, 10, 100));
        products.add(new Product(2, "T-Shirt", "Cotton T-Shirt", 800, 15, 50));
        products.add(new Product(3, "Headphones", "Noise Cancelling", 3500, 20, 30));
    }

    private static void showProducts(){
        System.out.println("\n---Products---");
        for (Product product: products){
            System.out.println(product.getId() + ". " + product.getProductName() + " - ₹" + product.getPrice() + " (Stock: " + product.getStock() + ")");
        }

        System.out.print("\n Enter product ID to add to cart (0 to cancel): ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id==0)return;

        Product selected = products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);

        if (selected == null){
            System.out.println("Invalid Product ID");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        if (qty <= 0 || qty > selected.getStock()) {
            System.out.println("Invalid quantity.");
            return;
        }

        cartItems.add(new CartItem(selected, qty, selected.getDiscountPercent()));
        selected.setStock(selected.getStock() - qty);

        System.out.println("Added to cart.");
    }

    private static void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println(" Cart is empty.");
            return;
        }

        System.out.println("\n--- Cart Items ---");
        double total = 0;
        double totalDiscount = 0;

        for (CartItem item : cartItems) {
            System.out.println(item);
            total += item.getTotalPriceBeforeDiscount();
            totalDiscount += item.getDiscountAmount();
        }

        double finalPrice = total - totalDiscount;

        System.out.println("Subtotal: ₹" + total);
        System.out.println("Total Discount: ₹" + totalDiscount);
        System.out.println("Total Payable: ₹" + finalPrice);
    }

    private static void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("🛒 Cart is empty. Nothing to checkout.");
            return;
        }

        showCart();
        System.out.print("Confirm Checkout? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("\n Order placed successfully! Thank you, " + loggedInUser.getName());
            cartItems.clear();
        } else {
            System.out.println(" Checkout cancelled.");
        }
    }

}
import java.util.*;

public class ECommerceApp {
    static List<Product> productList = new ArrayList<>();
    static Cart cart = new Cart();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadProducts();

        System.out.println("===== Welcome to Java E-Commerce App =====");
        User user = new User("nikhil", "1234");

        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (!user.login(uname, pass)) {
            System.out.println("Invalid login. Exiting...");
            return;
        }

        System.out.println("Login successful! Welcome " + uname);

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    removeFromCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void loadProducts() {
        productList.add(new Product(1, "Laptop", 55000, 5));
        productList.add(new Product(2, "Mobile", 20000, 10));
        productList.add(new Product(3, "Headphones", 1500, 20));
        productList.add(new Product(4, "Keyboard", 800, 15));
    }

    static void viewProducts() {
        System.out.println("---- Available Products ----");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    static Product findProductById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    static void addToCart() {
        viewProducts();
        System.out.print("Enter Product ID to add: ");
        int id = Integer.parseInt(sc.nextLine());
        Product p = findProductById(id);

        if (p == null) {
            System.out.println("Invalid Product ID.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        cart.addProduct(p, qty);
    }

    static void removeFromCart() {
        System.out.print("Enter Product ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        Product p = findProductById(id);

        if (p == null) {
            System.out.println("Invalid Product ID.");
            return;
        }

        cart.removeProduct(p);
    }

    static void checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty. Add products first.");
            return;
        }
        cart.showCart();
        System.out.println("Order placed successfully! Total paid: ₹" + cart.calculateTotal());
        cart.clearCart();
    }
}

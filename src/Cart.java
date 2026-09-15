import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantityToBuy) {
        if (product.getQuantity() >= quantityToBuy) {
            for (int i = 0; i < quantityToBuy; i++) {
                items.add(product);
            }
            product.setQuantity(product.getQuantity() - quantityToBuy);
            System.out.println(quantityToBuy + " x " + product.getName() + " added to cart.");
        } else {
            System.out.println("Sorry, not enough stock available for " + product.getName());
        }
    }

    public void removeProduct(Product product) {
        if (items.remove(product)) {
            product.setQuantity(product.getQuantity() + 1);
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println(product.getName() + " not found in cart.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("---- Your Cart ----");
        for (Product p : items) {
            System.out.println(p.getName() + " - ₹" + p.getPrice());
        }
        System.out.println("Total: ₹" + calculateTotal());
    }

    public List<Product> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }
}

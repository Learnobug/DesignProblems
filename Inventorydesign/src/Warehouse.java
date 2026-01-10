import java.util.List;

public class Warehouse {
    String location;
    int capacity;
    List<Product> products = new java.util.ArrayList<>();

    public Warehouse(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public boolean checkAvailability(Product product,int requestedQuantity) {
        return requestedQuantity <= product.getQuantity();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> listProducts() {
        return products;
    }

    public void restockProduct(Product product, int quantity) {
        product.add_quantity(quantity);
        System.out.println("Restocked " + quantity + " units of " + product.getName() + " in warehouse at " + location);
    }

    public boolean CanplaceOrder(Order order) {
        Product product = order.getProduct();
        int quantity = order.getQuantity();
        if (checkAvailability(product, quantity)) {
            System.out.println("Order placed for " + quantity + " units of " + product.getName());
            return true;
        }
            System.out.println("Insufficient stock for " + product.getName());
            return false;
    }

    public void placeOrder(Order order){
        if (CanplaceOrder(order)) {
            Product product = order.getProduct();
            int quantity = order.getQuantity();

            System.out.println("Order successfully placed.");
        } else {
            System.out.println("Order could not be placed due to insufficient stock.");
        }
    }
}

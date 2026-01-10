import java.util.List;

// Singleton InventoryManager to manage warehouses and product inventory
public class InventoryManager {
    List<Warehouse> warehouses = new java.util.ArrayList<>();

    static InventoryManager instance = null;

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }
    private InventoryManager() {}

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }
    public Warehouse findWarehouseWithProduct(Product product, int quantity) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.checkAvailability(product, quantity)) {
                return warehouse;
            }
        }
        return null;
    }

    public void transferProduct(Product product, Warehouse fromWarehouse, Warehouse toWarehouse, int quantity) {
        if (fromWarehouse.checkAvailability(product, quantity)) {
            fromWarehouse.removeProduct(product);
            toWarehouse.addProduct(product);
            System.out.println("Transferred " + quantity + " units of " + product.getName() + " from " + fromWarehouse.location + " to " + toWarehouse.location);
        } else {
            System.out.println("Insufficient stock in " + fromWarehouse.location + " to transfer.");
        }
    }

    public void restockProduct(Product product, int quantity) {
        for (Warehouse warehouse : warehouses) {
            warehouse.addProduct(product);
            System.out.println("Restocked " + quantity + " units of " + product.getName() + " in " + warehouse.location);
        }
    }

    public void placeOrderInWarehouse(Order order, Warehouse warehouse) {
        if (warehouse.CanplaceOrder(order)) {
            warehouse.placeOrder(order);
        } else {
            System.out.println("Order could not be placed in " + warehouse.location + " due to insufficient stock.");
        }
    }

    public void placeOrder(Order order) {
        Warehouse warehouse = findWarehouseWithProduct(order.getProduct(), order.getQuantity());
        if (warehouse != null) {
            placeOrderInWarehouse(order, warehouse);
        } else {
            System.out.println("No warehouse has sufficient stock for the order of " + order.getProduct().getName());
        }
    }

}

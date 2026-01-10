//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    InventoryManager inventoryManager = InventoryManager.getInstance();
    Warehouse warehouse1 = new Warehouse("New York", 1000);

    Product shoe1 = new shoes("Running Shoes", 79.99, 50, "Nike", "10");
    warehouse1.addProduct(shoe1);
    warehouse1.restockProduct(shoe1, 20);
    inventoryManager.addWarehouse(warehouse1);

    System.out.println("Hello and welcome to the Online Store!");
    Customer customer = new Customer("Alice", "xyz@gmail.com");
    Observer emailObserver = new EmailObserver(customer.getEmail());
    Order order1 = new Order(shoe1,70);
    order1.attach(emailObserver);
    inventoryManager.placeOrder(order1);

}

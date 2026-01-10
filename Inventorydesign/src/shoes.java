public class shoes extends Product {
    private String brand;
    private String size;

    public shoes(String name, double price, int quantity, String brand, String size) {
        super(name, price, quantity);
        this.brand = brand;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return "Brand: " + brand + ", Size: " + size;
    }

    @Override
    void reduce_quantity(int amount) {
        int currentQuantity = getQuantity();
        if (amount <= currentQuantity) {
            super.add_quantity(-amount);
        } else {
            System.out.println("Insufficient stock to reduce by " + amount);
        }
    }
}

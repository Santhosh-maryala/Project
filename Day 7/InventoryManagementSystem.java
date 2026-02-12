import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 1. Encapsulation: Product class with private stock
class Product {
    private String id;
    private String name;
    private int stock;

    public Product(String id, String name, int stock) {
        this.id = id;
        this.name = name;
        setStock(stock); // Uses setter to validate initial stock
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    // Prevent stock < 0
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Stock: " + stock;
    }
}

class InventoryManager {
    // 2. Map for storage
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.getId(), p);
    }

    public void updateStock(String id, int newStock) {
        if (inventory.containsKey(id)) {
            inventory.get(id).setStock(newStock);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String id) {
        inventory.remove(id);
    }

    // 3. Streams: Generate stock report
    public void generateReport() {
        System.out.println("\n--- Inventory Report ---");
        inventory.values().stream()
                .forEach(System.out::println);
        System.out.println("------------------------");
    }

    // 4. Overloading: Search by ID
    public Optional<Product> searchProduct(String id) {
        return Optional.ofNullable(inventory.get(id));
    }

    // 4. Overloading: Search by Name
    public Optional<Product> searchProduct(String name, boolean isNameSearch) {
        return inventory.values().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // 5. Bonus: Export to file
    public void exportReport(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Product p : inventory.values()) {
                writer.write(p.toString() + "\n");
            }
            System.out.println("Report exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        manager.addProduct(new Product("P01", "Laptop", 10));
        manager.addProduct(new Product("P02", "Mouse", 50));

        // Update Stock
        manager.updateStock("P01", 15);
        
        // Negative Stock Check
        try {
            manager.updateStock("P02", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Search Examples
        manager.searchProduct("P01").ifPresent(p -> System.out.println("Found: " + p.getName()));
        manager.searchProduct("Mouse", true).ifPresent(p -> System.out.println("Found: " + p.getId()));

        // Report
        manager.generateReport();
        
        // Export
        manager.exportReport("inventory_report.txt");
    }
}

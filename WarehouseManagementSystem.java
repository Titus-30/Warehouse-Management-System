import java.util.*;

// Base Class: Item
class Item {
    private String itemID;
    private String name;
    private double weight;
    private int quantity;

    public Item(String itemID, String name, double weight, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateStorageSpace() {
        return weight * quantity;
    }
}

// Subclasses of Item
class PerishableItem extends Item {
    public PerishableItem(String itemID, String name, double weight, int quantity) {
        super(itemID, name, weight, quantity);
    }

    @Override
    public double calculateStorageSpace() {
        return super.calculateStorageSpace() * 1.2; // Add refrigeration space
    }
}

class NonPerishableItem extends Item {
    public NonPerishableItem(String itemID, String name, double weight, int quantity) {
        super(itemID, name, weight, quantity);
    }

    @Override
    public double calculateStorageSpace() {
        return super.calculateStorageSpace(); // No extra space needed
    }
}

class FragileItem extends Item {
    public FragileItem(String itemID, String name, double weight, int quantity) {
        super(itemID, name, weight, quantity);
    }

    @Override
    public double calculateStorageSpace() {
        return super.calculateStorageSpace() * 1.5; // Add padding space
    }
}

// Interface: InventoryManagement
interface InventoryManagement {
    void trackItem(String itemID);
    void updateStock(String itemID, int quantity);
    void generateReport();
}

// Base Class: Warehouse
class Warehouse implements InventoryManagement {
    private String warehouseID;
    private String location;
    private double capacity;
    private List<Item> items;

    public Warehouse(String warehouseID, String location, double capacity) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        double totalSpace = items.stream().mapToDouble(Item::calculateStorageSpace).sum();
        if (totalSpace + item.calculateStorageSpace() <= capacity) {
            items.add(item);
            System.out.println(item.getName() + " added to the warehouse.");
        } else {
            System.out.println("Not enough capacity to add " + item.getName());
        }
    }

    public void removeItem(String itemID) {
        items.removeIf(item -> item.getItemID().equals(itemID));
        System.out.println("Item with ID " + itemID + " removed from the warehouse.");
    }

    @Override
    public void trackItem(String itemID) {
        items.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .forEach(item -> System.out.println("Tracking item: " + item.getName()));
    }

    @Override
    public void updateStock(String itemID, int quantity) {
        for (Item item : items) {
            if (item.getItemID().equals(itemID)) {
                item.setQuantity(quantity);
                System.out.println("Stock updated for item: " + item.getName());
            }
        }
    }

    @Override
    public void generateReport() {
        System.out.println("Warehouse Report:");
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getQuantity() + " units");
        }
    }
}

// Driver Program
public class WarehouseManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a warehouse
        System.out.print("Enter Warehouse ID: ");
        String warehouseID = scanner.nextLine();

        System.out.print("Enter Warehouse Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Warehouse Capacity: ");
        double capacity = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline character

        Warehouse warehouse = new Warehouse(warehouseID, location, capacity);

        while (true) {
            System.out.println("\n--- Warehouse Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Track Item");
            System.out.println("4. Update Stock");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    // Add Item
                    System.out.print("Enter Item ID: ");
                    String itemID = scanner.nextLine();

                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter Item Weight: ");
                    double weight = scanner.nextDouble();

                    System.out.print("Enter Item Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Item Type (Perishable/NonPerishable/Fragile): ");
                    String itemType = scanner.nextLine();

                    Item item = null;
                    switch (itemType.toLowerCase()) {
                        case "perishable":
                            item = new PerishableItem(itemID, itemName, weight, quantity);
                            break;
                        case "nonperishable":
                            item = new NonPerishableItem(itemID, itemName, weight, quantity);
                            break;
                        case "fragile":
                            item = new FragileItem(itemID, itemName, weight, quantity);
                            break;
                        default:
                            System.out.println("Invalid item type!");
                            continue;
                    }
                    warehouse.addItem(item);
                    break;

                case 2:
                    // Remove Item
                    System.out.print("Enter Item ID to remove: ");
                    String removeID = scanner.nextLine();
                    warehouse.removeItem(removeID);
                    break;

                case 3:
                    // Track Item
                    System.out.print("Enter Item ID to track: ");
                    String trackID = scanner.nextLine();
                    warehouse.trackItem(trackID);
                    break;

                case 4:
                    // Update Stock
                    System.out.print("Enter Item ID to update stock: ");
                    String updateID = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    warehouse.updateStock(updateID, newQuantity);
                    break;

                case 5:
                    // Generate Report
                    warehouse.generateReport();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting Warehouse Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

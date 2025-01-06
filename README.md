# Warehouse Management System

## Introduction

This Java-based Warehouse Management System provides a robust solution for managing inventory in a warehouse environment. The system offers functionalities such as adding and removing items, tracking items, updating stock, and generating inventory reports. It is designed with modular and extensible principles to adapt to different types of items and inventory management requirements.

## Features

### Inventory Management
- **Add Item**: Add new items to the warehouse, with support for different item types such as perishable, non-perishable, and fragile items.
- **Remove Item**: Remove items from the warehouse inventory by their ID.
- **Track Item**: Locate items in the warehouse using their ID.
- **Update Stock**: Modify the stock quantity for any item.
- **Generate Report**: Create a summary report of all items and their quantities.

### Item Types
- **Perishable Items**: Require additional storage space due to refrigeration needs.
- **Non-Perishable Items**: Standard items that require no extra storage considerations.
- **Fragile Items**: Require additional storage space for padding to ensure safety.

### Extensibility
- Supports adding new item types by extending the base `Item` class.
- Provides interfaces and base classes to easily integrate new functionalities.

## Code Structure

### Classes

#### Item Hierarchy
- **`Item`**: Base class representing general item properties such as ID, name, weight, and quantity.
- **`PerishableItem`**: Subclass of `Item` with additional storage requirements.
- **`NonPerishableItem`**: Subclass of `Item` with standard storage requirements.
- **`FragileItem`**: Subclass of `Item` with increased storage requirements for safety padding.

#### Warehouse and Management
- **`Warehouse`**: Manages inventory and implements the `InventoryManagement` interface.
- **`InventoryManagement` Interface**: Defines methods for inventory-related operations such as tracking items, updating stock, and generating reports.

#### Main Class
- **`WarehouseManagementSystem`**: Entry point of the program, providing a console-based menu for user interaction.

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your machine.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/warehouse-management-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd warehouse-management-system
   ```

3. Compile the program:
   ```bash
   javac WarehouseManagementSystem.java
   ```

4. Run the program:
   ```bash
   java WarehouseManagementSystem
   ```

5. Follow the on-screen menu to interact with the system.

## Example Usage

1. Add a perishable item:
   - Input item ID, name, weight, quantity, and specify the type as "Perishable".
   - The system checks for capacity and adds the item if sufficient space is available.

2. Remove an item:
   - Enter the item ID to remove it from the warehouse.

3. Track an item:
   - Enter the item ID to locate the item and display its details.

4. Update stock:
   - Specify the item ID and the new quantity to modify stock levels.

5. Generate report:
   - View a summary of all items in the warehouse with their quantities and types.

## Key Concepts Demonstrated

### Object-Oriented Programming
- **Inheritance**: Specialized classes like `PerishableItem`, `NonPerishableItem`, and `FragileItem` inherit common properties and methods from the `Item` class.
- **Polymorphism**: Method overriding in item subclasses for customized storage space calculations.
- **Encapsulation**: Secure and organized access to item properties.

### Interfaces
- **`InventoryManagement`**: Provides a common interface for inventory-related operations, ensuring consistency and modularity.

### Data Structures
- Uses Java's `ArrayList` to manage and store inventory items dynamically.

## Future Enhancements

### Planned Features
- Integrate a database for persistent storage of inventory.
- Implement a graphical user interface (GUI) for improved user interaction.
- Add real-time notifications for low stock or capacity limits.
- Introduce advanced search and filter functionalities for tracking items.

## Contribution

Contributions to this project are welcome! Feel free to fork the repository, implement new features or fixes, and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


import java.util.*;
public class InventorySystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductInventory inventory = new ProductInventory();
        OrderManager orderManager = new OrderManager();


        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
        inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));
        boolean running = true;

        while (running) {
            System.out.println("Menu System: ");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. List All Products");
            System.out.println("5. Create Order");
            System.out.println("6. View Orders");
            System.out.println("7. Process Order");
            System.out.println("8. Generate Reports");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Supplier: ");
                    String supplier = scanner.nextLine();

                    inventory.addProduct(new Product(id, name, category, price, qty, supplier));
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    boolean removed = inventory.removeProduct(removeId);
                    System.out.println("Removed: " + removed);
                    break;

                case 3:
                    System.out.print("Enter Product ID to find: ");
                    String findId = scanner.nextLine();
                    Product p = inventory.findProduct(findId);
                    if (p == null)
                        System.out.println("Product not found.");
                    else
                        System.out.println(p);
                    break;
                case 4:
                    inventory.printAllProducts();
                    break;

                case 5:
                    System.out.print("Order ID: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = scanner.nextLine();
                    System.out.print("Order Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    Order order = new Order(orderId, customer, date);

                    boolean adding = true;
                    while (adding) {
                        System.out.print("Enter Product ID (or 'done'): ");
                        String pid = scanner.nextLine();
                        if (pid.equalsIgnoreCase("done")) {
                            adding = false;
                        } else {
                            System.out.print("Product Name: ");
                            String pname = scanner.nextLine();
                            System.out.print("Quantity: ");
                            int q = Integer.parseInt(scanner.nextLine());
                            System.out.print("Unit Price: ");
                            double up = Double.parseDouble(scanner.nextLine());
                            order.addItem(new OrderItem(pid, pname, q, up));
                        }
                    }
                    orderManager.addOrder(order);
                    break;
                case 6:
                    orderManager.printAllOrders();
                    break;
                case 7:
                    System.out.print("Enter Order ID to process: ");
                    String processId = scanner.nextLine();
                    Order o = orderManager.findOrder(processId);
                    if (o == null) {
                        System.out.println("Order not found.");
                    } else {
                        System.out.print("Enter new status (Pending/Processing/Shipped/Delivered/Cancelled): ");
                        String status = scanner.nextLine();
                        o.updateStatus(status);
                        System.out.println("Order updated.");
                    }
                    break;
                case 8:
                    System.out.println("----- Reports -----");
                    System.out.println("Total Products: " + inventory.getTotalProducts());
                    System.out.println("Total Inventory Value: $" + inventory.getTotalInventoryValue());
                    inventory.printCapacityInfo();
                    inventory.printCapacityReport();
                    System.out.println("Pending Orders: " + orderManager.getPendingOrders().size());
                    System.out.println("Total Delivered Revenue: $" + orderManager.getTotalRevenue());

                    Vector<Integer> ints = new Vector<Integer>();
                    ints.add(10);
                    ints.add(20);
                    ints.add(30);
                    System.out.println("Sum: " + VectorUtils.sumNumbers(ints));
                    System.out.println("Average: " + VectorUtils.averageNumbers(ints));
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();

        }
        scanner.close();
    }
}

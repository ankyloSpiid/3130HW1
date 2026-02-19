import java.util.Vector;

public class Order {
    private String orderID, customerName, orderDate, orderStatus;
    private Vector<OrderItem> items;

    public Order(String orderID, String customerName, String orderDate) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderStatus = "Pending";
        this.items = new Vector<OrderItem>();
    }

    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public boolean removeItem(String productID){
        for(int i = 0 ; i < items.size(); i++){
            if(items.get(i).getProductID().equals(productID)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }
    public OrderItem findItem(String productID){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getProductID().equals(productID)){
                return items.get(i);
            }
        }
        return null;
    }

    public double calculateTotal(){
        double total =0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).calcSubtotal();
        }
        return total;
    }

    public int getTotalItems(){
        int totalQ= 0;
        for(int i = 0; i < items.size(); i++){
            totalQ =+ items.get(i).getQuantity();
        }
        return totalQ;
    }

    public void updateStatus(String newStatus){
        orderStatus=newStatus;
    }

    public void printOrder(){
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + orderStatus);

        System.out.println("Items: ");
        if(items.size()==0){
            System.out.println("No items.");
        }else{
            for(int i = 0 ; i < items.size(); i++){
                System.out.println(" " + items.get(i));
            }
        }

        System.out.println("Total Quantity: " + getTotalItems());
        System.out.println("Order Total: " + calculateTotal());
        System.out.println("----------------------------------");
    }

    public Vector<OrderItem> getItems() {
        return new Vector<OrderItem>(items);
    }

}//end

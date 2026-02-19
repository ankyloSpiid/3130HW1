import java.util.*;
public class OrderManager {
    private Vector<Order> orders;

    public OrderManager(){
        orders = new Vector<Order>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order findOrder(String orderID){
        for(int i =0 ; i <orders.size(); i++){
            if(orders.get(i).getOrderID().equals(orderID)){
                return orders.get(i);
            }
        }
        return null;
    }

    public Vector<Order> getOrdersByStatus(String status){
        Vector<Order> result = new Vector<Order>();
        for(int i = 0 ; i < orders.size(); i++){
            if(orders.get(i).getOrderStatus().equalsIgnoreCase(status)){
                result.add(orders.get(i));
            }
        }
        return result;
    }

    public Vector<Order> getOrderByCustomer(String customerName){
        Vector<Order> result = new Vector<Order>();
        for (int i =0; i< orders.size(); i++) {
            if (orders.get(i).getCustomerName().equalsIgnoreCase(customerName)){
                result.add(orders.get(i));
            }
        }
        return result;
    }

    public double getTotalRevenue(){
        double total=0;
        for(int i = 0; i< orders.size(); i++){
            if(orders.get(i).getOrderStatus().equalsIgnoreCase("Delivered")){
                total+= orders.get(i).calculateTotal();
            }
        }
        return total;
    }

    public void cancelOrder(String orderID){
        Order o = findOrder(orderID);
        if(o!=null){
            o.updateStatus("cancelled");
        }
    }

    public void printAllOrders(){
        if(orders.isEmpty()) {
            System.out.println("No orders.");
            return;
        }
        for(int i = 0; i < orders.size(); i++) {
            orders.get(i).printOrder();
        }
    }

    public Vector<Order> getPendingOrders() {
        return getOrdersByStatus("Pending");
    }

    public int getOrderCount() {
        return orders.size();
    }

}//end

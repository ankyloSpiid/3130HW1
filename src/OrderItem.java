public class OrderItem {
    private String productID, productName;
    private int quantity;
    private double unitPrice, subtotal;

    public OrderItem(String productID, String productName, int quantity, double unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = quantity * unitPrice;
    }

    public String getProductID(){ return productID;}
    public void setProductID(String productID){
        this.productID=productID;
    }

    public String getProductName(){ return productName;}
    public void setProductName(String productName){
        this.productName=productName;
    }

    public int getQuantity(){ return quantity;}
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public double getUnitPrice(){ return unitPrice;}
    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }

    public double getSubtotal(){ return subtotal;}
    public void setSubtotal(double subtotal){
        this.subtotal=subtotal;
    }

    @Override
    public String toString(){
        return "OrderItem{" +
                "productId='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }

    public double calcSubtotal(){
        subtotal= quantity*unitPrice;
        return subtotal;
    }

}// end

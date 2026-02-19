import java.util.*;
public class Product {
    private String productID, name, category, supplier;;
    private double price;
    private int quantityInStock;

    public Product(String productID, String name, String category,
                   double price, int quantityInStock, String supplier){
        this.productID=productID;
        this.name=name;
        this.category=category;
        this.price=price;
        this.quantityInStock=quantityInStock;
        this.supplier=supplier;
    }

    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID){
        this.productID=productID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier(){
        return supplier;
    }
    public void setSupplier(String supplier){
        this.supplier=supplier;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public int getQuantityInStock(){
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock){
        this.quantityInStock=quantityInStock;
    }

    @Override
    public String toString(){
        return "Product ID: " + productID + ", Name: " + name + ", Category: " +
                category + ", Price: " + price + ", Quantity in Stock: " +
                quantityInStock + ", Supplier: " + supplier;
    }

    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return Objects.equals(this.productID, other.productID);
    }

    @Override
    public int hashCode(){
        return Objects.hash(productID);
    }
}

import java.util.*;

public class ProductInventory {
    private final Vector<Product> products;

    public ProductInventory(){
        this.products=new Vector<>();
    }

    public void addProduct(Product product){
        if(findProduct(product.getProductID()) != null){
            System.out.println("Duplicate found. Not added: " + product.getProductID());
            return;
        }
        products.add(product);
    }

    public boolean removeProduct(String productID){
        if(productID == null || productID.trim().isEmpty()) return false;

        for(int i = 0 ; i < products.size() ; i++){
            if(products.get(i).getProductID().equals(productID.trim())){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productID) {
        if (productID == null || productID.trim().isEmpty()) return null;

        String id = productID.trim();
        for(int i = 0 ; i<products.size(); i++){
            Product p = products.get(i);
            if(p.getProductID().equals(id)) return p;
        }
        return null;
    }

    public Vector<Product> getProductsByCategory(String category){
        Vector<Product> results = new Vector<>();
        if(category==null || category.trim().isEmpty()) return results;

        String c = category.trim();
        for(int i =0 ; i < products.size(); i++){
            Product p = products.get(i);
            if(p.getCategory().equalsIgnoreCase(c)){
                results.add(p);
            }
        }
        return results;
    }

    public Vector<Product> getLowStockProducts(int threshold){
        Vector<Product> result= new Vector<>();
        if(threshold<0) return result;

        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if(p.getQuantityInStock() < threshold){
                result.add(p);
            }
        }
        return result;
    }

    public double getTotalInventoryValue(){
        double total = 0.0;
        for(int i = 0 ; i <products.size(); i++){
            Product p = products.get(i);
            total += p.getPrice() * p.getQuantityInStock();
        }
        return total;
    }

    public void updateStock(String productID, int quantityChange){
        Product p = findProduct(productID);
        if(p==null){
            System.out.println("Product not found: " + productID);
            return;
        }

        int newQty= p.getQuantityInStock() + quantityChange;
        p.setQuantityInStock(newQty);
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-6s | %-18s | %-12s | %-10s | %-5s | %-15s%n",
                "ID", "Name", "Category", "Price", "Stock", "Supplier");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.printf("%-6s | %-18s | %-12s | $%-9.2f | %-5d | %-15s%n",
                    p.getProductID(),
                    truncate(p.getName(), 18),
                    truncate(p.getCategory(), 12),
                    p.getPrice(),
                    p.getQuantityInStock(),
                    truncate(p.getSupplier(), 15));
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private String truncate(String s, int maxL) {
        if (s == null) return "";
        return (s.length() <= maxL) ? s : s.substring(0, maxL - 3) + "...";
    }

    public int getTotalProducts(){
        return products.size();
    }

    public void printCapacityInfo(){
        System.out.println("Vector size: " + products.size());
        System.out.println("Vector capacity: " + products.capacity());
    }


    //part 3

    public void optimizeCapacity(){
        products.trimToSize();
    }
    public void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }
    public void printCapacityReport(){
        int size= products.size();
        int capacity= products.capacity();
        double util=0;

        if(capacity > 0 ){
            util= (size*100.0)/capacity;
        }
        int remainingB4resize = capacity-size;

        System.out.println("Capacity Report: ");
        System.out.println("Current size: " + size);
        System.out.println("Current capacity: " + capacity);
        System.out.println("Capacity utilization: " + util + "%");
        System.out.println("Elements before resize: " + remainingB4resize);
        System.out.println("\n");
    }


    public void printProductsUsingEnumeration(){
        Enumeration<Product> e = products.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }



}//end


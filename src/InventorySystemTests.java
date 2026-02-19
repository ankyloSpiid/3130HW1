import java.util.*;
public class InventorySystemTests {

    public static void main(String [] args){
        testVectorOperations();
        testEdgeCases();
        testGenericMethods();
        testCapacityManagement();
        System.out.println("Tests completed.");
    }

    private static void testCapacityManagement() {
        ProductInventory inv = new ProductInventory();

        inv.ensureCapacity(50);
        inv.addProduct(new Product("P1", "A", "Cat", 1.0, 1, "S"));
        inv.addProduct(new Product("P2", "B", "Cat", 1.0, 1, "S"));

        inv.printCapacityReport();

        inv.optimizeCapacity();
        inv.printCapacityReport();
    }

    private static void testGenericMethods() {
        Vector<String> words = new Vector<String>();
        words.add("A");
        words.add("B");
        VectorUtils.swap(words, 0, 1);
        if (!words.get(0).equals("B")) System.out.println("FAIL: swap with String");

        Vector<Integer> nums = new Vector<Integer>();
        nums.add(10);
        nums.add(5);
        nums.add(30);
        Integer max = VectorUtils.findMax(nums);
        if (max == null || max != 30) System.out.println("FAIL: findMax with Integer");

        int count = VectorUtils.countMatches(words, "B");
        if (count != 1) System.out.println("FAIL: countMatches with String");

        Vector<Integer> filtered = VectorUtils.filter(nums, new VectorUtils.Predicate<Integer>() {
            public boolean test(Integer v) {
                return v >= 10;
            }
        });
        if (filtered.size() != 2) System.out.println("FAIL: filter with Integer");

    }

    private static void testEdgeCases() {
        ProductInventory inv = new ProductInventory();

        if (inv.getTotalProducts() != 0) System.out.println("FAIL: empty inventory count");
        if (inv.removeProduct("X") != false) System.out.println("FAIL: remove non-existing should be false");
        if (inv.getProductsByCategory("Anything").size() != 0) System.out.println("FAIL: category on empty");
        if (inv.getLowStockProducts(5).size() != 0) System.out.println("FAIL: low stock on empty");

        Vector<Integer> emptyNums = new Vector<Integer>();
        if (VectorUtils.findMax(emptyNums) != null) System.out.println("FAIL: findMax on empty should be null");

        Vector<Integer> nums = new Vector<Integer>();
        nums.add(1);
        try {
            VectorUtils.swap(nums, 0, 5);
            System.out.println("FAIL: swap invalid indices should throw");
        } catch (Exception e) {
        }

    }

    private static void testVectorOperations() {
        ProductInventory inv = new ProductInventory();

        inv.addProduct(new Product("P1", "A", "Cat1", 10.0, 5, "S1"));
        inv.addProduct(new Product("P2", "B", "Cat2", 20.0, 3, "S2"));

        if (inv.getTotalProducts() != 2) System.out.println("FAIL: add/getTotalProducts");

        boolean removed = inv.removeProduct("P2");
        if (!removed) System.out.println("FAIL: removeProduct should return true");
        if (inv.getTotalProducts() != 1) System.out.println("FAIL: removeProduct count wrong");

        Vector<Product> cat1 = inv.getProductsByCategory("Cat1");
        if (cat1.size() != 1) System.out.println("FAIL: getProductsByCategory");

        inv.updateStock("P1", 2);
        Vector<Product> low = inv.getLowStockProducts(10);
        if (low.size() != 1) System.out.println("FAIL: getLowStockProducts");

    }


}

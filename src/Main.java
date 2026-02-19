import java.util.*;
public class Main {
    public static void main(String[] args){
        Vector<Integer> ints = new Vector<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
        System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0
    }
}

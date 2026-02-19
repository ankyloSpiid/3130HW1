import java.util.*;
public class VectorUtils {

    public interface Predicate<T>{
        boolean test(T value);
    }

    public static <T> void swap(Vector<T> vec, int index1, int index2){
        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2,temp);
    }

    public static <T extends Comparable<T>> T findMax(Vector<T> vec){
        if(vec.size() == 0){return null;}

        T max= vec.get(0);
        for(int i = 1; i<vec.size(); i++){
            if(vec.get(i).compareTo(max)>0){
                max=vec.get(i);
            }
        }
        return max;
    }

    public static <T> int countMatches(Vector<T> vec, T target){
        int count =0 ;
        for(int i =0; i < vec.size(); i++){
            if(target==null){
                if(vec.get(i)==null) count++;
            }else{
                if(target.equals(vec.get(i))) count++;
            }
        }
        return count;
    }

    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition){
        Vector<T> result = new Vector<T>();
        for(int i =0 ; i < vec.size(); i++){
            T item = vec.get(i);
            if(condition.test(item)){
                result.add(item);
            }
        }
        return result;
    }

    //4.3
    public static <T extends Number> double sumNumbers(Vector<T> numbers){
        double sum = 0.0;
        for( int i=0; i< numbers.size(); i++){
            sum+= numbers.get(i).doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double averageNumbers(Vector<T> numbers){
        if(numbers.size() == 0){return 0.0;}
        return sumNumbers(numbers)/numbers.size();
    }



}//end

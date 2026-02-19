import java.util.*;
public class GenericContainer<T>{
    private Vector<T> items;

    public GenericContainer(){
        items = new Vector<T>();
    }
    public void add(T item){
        items.add(item);
    }
    public T get(int index){
        return items.get(index);
    }
    public boolean remove(T item){
        return items.remove(item);
    }
    public int size(){
        return items.size();
    }
    public Vector<T> getAll(){
        return new Vector<T>(items);
    }
    public void clear(){
        items.clear();
    }
    public boolean contains(T item){
        return items.contains(item);
    }
    public void addAll(Vector<T> other){
        items.addAll(other);
    }
}

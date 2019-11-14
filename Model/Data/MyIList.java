package Model.Data;

public interface MyIList<T> {
    void add(int position,T element);
    void add(T element);
    void remove(int position);
    T get(int position);
    int size();
    boolean isEmpty();
}

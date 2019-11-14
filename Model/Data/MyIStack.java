package Model.Data;

public interface MyIStack<T> {
    T pop();
    void push(T v);
    String toString();
    boolean isEmpty();
    int size();


}

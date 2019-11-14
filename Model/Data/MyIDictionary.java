package Model.Data;

public interface MyIDictionary<T,V> {
    void add(T key, V value);
    void remove(T key);
    V get(T key);
    void update(T key,V value);
    String toString();
    boolean isDefined(T key);
}

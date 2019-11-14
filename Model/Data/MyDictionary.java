package Model.Data;


import java.util.HashMap;

public class MyDictionary<T,V> implements MyIDictionary<T,V> {
    private HashMap<T,V> dict;

    public MyDictionary() {
        this.dict=new HashMap<T,V>();
    }

    @Override
    public void add(T key,V value){
        this.dict.put(key,value);
    }

    @Override
    public void remove(T key){
        dict.remove(key);
    }

    @Override
    public V get(T key){
        return dict.get(key);
    }

    @Override
    public void update(T key, V value){
        this.dict.put(key,value);
    }

    @Override
    public String toString(){
        StringBuilder string= new StringBuilder();
        for (T key:dict.keySet()) {
            string.append("Key: ").append(key.toString()).append(" ").append("Value: ").append(dict.get(key)).append("\n");
        }
        return string.toString();
    }

    @Override
    public boolean isDefined(T key){
        return dict.containsKey(key);
    }

}

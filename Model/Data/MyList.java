package Model.Data;

import java.util.Vector;

public class MyList<T> implements MyIList<T> {
    private Vector<T> list;
    public MyList(){
        this.list=new Vector<T>();
    }

    @Override
    public void add(int position, T element){
        list.add(position,element);
    }

    @Override
    public void add(T element){
        list.add(element);
    }
    @Override
    public void remove(int position){
        list.remove(position);
    }

    @Override
    public String toString() {
        String string="";
        for (T el:list){
            string=string+el.toString()+"\n";
        }
        return string;
    }

    @Override
    public T get(int position){
        return list.get(position);
    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
}

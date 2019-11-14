package Model.Data;


import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack;
    public MyStack()
    {
        this.stack= new Stack<T>();
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }


    @Override
    public void push(T v){
        stack.push(v);
    }

    @Override
    public String toString(){
        StringBuilder string= new StringBuilder();
        for(T elem:this.stack) {
            string.append(elem.toString()).append("\n");
        }
        return string.toString();
    }

    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public int size(){
        return stack.size();
    }

}

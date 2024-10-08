package org.example.ObjectOriented.Stack;

public class CustomStack<T> {
    private T[] data;
    private int size;
    private final static int DEFAULT_SIZE = 10;

    CustomStack(){
        this(DEFAULT_SIZE);
    }

    CustomStack(int size){
        this.data = (T[]) new Object[size];
    }

    public boolean push(T t){
        if(isFull()){
            expand();
        }
        data[size++] = t;
        return true;
    }

    public T pop(){
        return data[size--];
    }

    private void expand() {
        T[] temp = (T[]) new Object[data.length * 2];
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length - 1;
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[ ");
        for(int i=0; i<size; i++){
            str.append(data[i] + " ");
        }
        return str.append("]").toString();
    }
}

package org.example.ObjectOriented.Queue;

public class CustomQueue<T> {
    private T[] data;
    private final static int DEFAULT_SIZE = 10;
    private int start = 0;
    private int end = 0;
    CustomQueue(){
        this(DEFAULT_SIZE);
    }
    CustomQueue(int size){
        this.data = (T[]) new Object[size];
    }

    public boolean add(T t){
        if(isFull()){
            expand();
        }
        end = end % data.length;
        data[end++] = t;
        return true;
    }

    public T remove(){
        return data[start++];
    }

    private void expand(){
        T[] temp = (T[]) new Object[data.length * 2];
        int i = start;
        do{
            i = i % data.length;
            temp[i] = data[i];
            i++;
        } while(i != end);
        data = temp;
    }
    private boolean isFull() {
        return (start != 0 && start == end) || (start == 0 && end == data.length);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[ ");
        int i = start;
        do{
            i = i % data.length;
            str.append(data[i] + " ");
            i++;
        } while(i != end);
        return str.append("]").toString();
    }
}

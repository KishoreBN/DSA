package org.example.ObjectOriented.Generics;

import java.util.Arrays;

public class CustomArrayList<T> {
    Object[] arr;

    int size;

    int DEFAULT_SIZE = 10;

    CustomArrayList(){
        this.arr = new Object[DEFAULT_SIZE];
    }

    CustomArrayList(int size){
        this.arr = new Object[size];
    }

    public void add(T num){
        if(size > arr.length){
            increaseSize();
        }
        arr[size] = num;
        size++;
    }

    public void remove(){
        size--;
    }

    public T remove(int index){
        T removed = (T) arr[index];
        for(int i=index; i<size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return removed;
    }

    private void increaseSize() {
        Object[] temp = new Object[size * 2];
        for(int i=0; i<size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0; i<size; i++){
            str.append(" ");
            str.append(arr[i]);
        }
        str.append(" ]");
        return str.toString();
    }
}

package org.example.ObjectOriented.Generics;

public class Utility{
    public static <T> String printElements(T[] t){
        StringBuilder str = new StringBuilder("[ ");
        for(T i : t){
            str.append(i.toString() + " ");
        }
        return str.append("]").toString();
    }

}

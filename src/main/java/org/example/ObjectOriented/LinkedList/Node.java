package org.example.ObjectOriented.LinkedList;

public class Node<T>{
    T value;
    Node next;
    Node(){

    }

    public Node(T value, Node node){
        this.value = value;
        this.next = node;
    }
    public Node(T value){
        this.value = value;
    }
}

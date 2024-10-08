package org.example.LinkedList;

public class Node<T>{
    public T value;
    public Node next;
    Node(T value){
        this.value = value;
    }
    Node(T value, Node next){
        this.value = value;
        this.next = next;
    }
}

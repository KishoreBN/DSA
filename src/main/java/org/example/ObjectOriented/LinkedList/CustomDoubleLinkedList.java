package org.example.ObjectOriented.LinkedList;

public class CustomDoubleLinkedList<T>{
    class Node<T>{
        Node prev;
        T value;
        Node next;
        Node(T value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    CustomDoubleLinkedList(){
        size=0;
    }

    public void insert(T value){
        size++;
        Node node = new Node(value);
        if(tail == null){
            head = node;
            tail = node;
            return;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public void remove(int index){
        if(index == 0){
            head = head.next;
            head.prev = null;
            return;
        }
        if(index == size - 1){
            tail = tail.prev;
            tail.next = null;
            return;
        }
        if(index > size){
            throw new ArrayIndexOutOfBoundsException("Index passed is greater than size of the linked list");
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    @Override
    public String toString(){
        Node temp = head;
        StringBuilder str = new StringBuilder();
        while(temp != null){
            str.append(temp.value + " ");
            temp = temp.next;
        }
        return str.toString();
    }
}

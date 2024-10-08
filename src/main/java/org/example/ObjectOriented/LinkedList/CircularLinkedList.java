package org.example.ObjectOriented.LinkedList;

public class CircularLinkedList <T>{
    class Node <T>{
        public T value;
        public Node next;
        Node(T value){
            this.value = value;
        }
    }
    public Node head;
    public Node tail;
    public int size;

    CircularLinkedList(){
        size = 0;
    }

    public void insert(T value){
        size++;
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
//            node.next = node;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void remove(T value){
        Node temp = head;
        if(temp.value == value){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = temp.next;
            if(n.value == value){
                temp.next = n.next;
            }
            temp = temp.next;
        }while(temp != head);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node temp = head;
        do{
            str.append(temp.value + " ");
            temp = temp.next;
        }while(temp != head);
        return str.toString();
    }
}

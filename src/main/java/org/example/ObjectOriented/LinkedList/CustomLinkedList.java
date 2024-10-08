package org.example.ObjectOriented.LinkedList;

public class CustomLinkedList<T> {
    public Node head;
    public Node tail;
    public int size;

    public CustomLinkedList(){
        size = 0;
    }

    public void insert(T value){
        Node node = new Node(value);
        if(head == null)
            head = node;
        if(tail == null)
            tail = node;
        else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T remove(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException("Index passed is greater than size of the linked list");
        }
        size--;
        if(index == 0){
            Node temp = head;
            head = head.next;
            return (T) temp.value;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        Node removed = temp.next;
        temp.next = temp.next.next;
        return (T) removed.value;
    }

    public T get(int index){
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return (T) temp.value;
    }

    public void insertUsingRecursion(int index, T value){
        head = recursionHelper(index, value, head);
    }

    private Node recursionHelper(int index, T value, Node node){
        if(index == 0){
            Node newNode = new Node(value, node);
            return newNode;
        }
        node.next = recursionHelper(index - 1, value, node.next);
        return node;
    }

    @Override
    public String toString(){
        Node iterator = head;
        StringBuilder str = new StringBuilder();
        while(iterator != null){
            str.append(iterator.value + " ");
            iterator = iterator.next;
        }
        return str.toString();
    }
}

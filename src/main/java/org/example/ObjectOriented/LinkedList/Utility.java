package org.example.ObjectOriented.LinkedList;

public class Utility {
    public static void printLinkedList(Node head){
        StringBuilder str = new StringBuilder("[ ");
        while(head != null){
            str.append(head.value + " ");
            head = head.next;
        }
        str.append("]");
        System.out.println(str);
    }
}

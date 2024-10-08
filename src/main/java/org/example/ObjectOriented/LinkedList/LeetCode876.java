package org.example.ObjectOriented.LinkedList;

public class LeetCode876 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(3);
        list.insert(2);
        list.insert(0);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.out.println(middleNode(list.head).value);
    }

    public static Node middleNode(Node head) {
        Node slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}

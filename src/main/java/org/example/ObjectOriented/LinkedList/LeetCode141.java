package org.example.ObjectOriented.LinkedList;

public class LeetCode141 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(3);
        list.insert(2);
        list.insert(0);
        list.insert(4);
        list.tail.next = list.head.next.next;
        System.out.println(hasCycle(list.head));
        System.out.println(cycleLength(list.head));
    }

    public static boolean hasCycle(Node head) {
        Node slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer)
                return true;
        }
        return false;
    }

    public static int cycleLength(Node head){
        Node slowPointer = head, fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer){
                int length = 0;
                do{
                    slowPointer = slowPointer.next;
                    length++;
                }while(slowPointer != fastPointer);
                return length;
            }
        }
        return 0;
    }
}

package org.example.ObjectOriented.LinkedList;

public class LeetCode142 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(3);
        list.insert(2);
        list.insert(0);
        list.insert(4);
//        list.tail.next = list.head.next.next.next;
        System.out.println(detectCycle(list.head));
    }

    public static Node detectCycle(Node head) {
        int length = cycleLength(head);
        if(length > 0){
            Node slowPointer = head, fastPointer = head;
            for(int i=0; i< length; i++){
                slowPointer = slowPointer.next;
            }
            while(slowPointer != null && slowPointer.next != null){
                if(slowPointer == fastPointer){
                    return slowPointer;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        return null;
    }

    public static int cycleLength(Node head){
        Node fastPointer = head, slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(slowPointer == fastPointer){
                int length = 0;
                do{
                    slowPointer = slowPointer.next;
                    length++;
                } while(slowPointer != fastPointer);
                return length;
            }
        }
        return 0;
    }
}

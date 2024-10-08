package org.example.ObjectOriented.LinkedList;

public class LeetCode2095 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(-1);
//        list.insert(5);
//        list.insert(3);
//        list.insert(4);
//        list.insert(0);
        Utility.printLinkedList(deleteMiddle(list.head));
    }

    public static Node deleteMiddle(Node head) {
        if(head == null || head.next == null){
            return null;
        }
        Node slowPointer = head, fastPointer = head, prevNode = null;
        while(fastPointer != null && fastPointer.next != null){
            prevNode = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        prevNode.next = slowPointer.next;
        return head;
    }
}

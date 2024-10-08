package org.example.ObjectOriented.LinkedList;

public class LeetCode19 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        Utility.printLinkedList(removeNthFromEnd(list.head, 2));
    }

    public static Node removeNthFromEnd(Node head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        Node fastPointer = null, slowPointer = null;
        int count = n;
        while(count > 0){
            fastPointer = (fastPointer == null) ? head : fastPointer.next;
            count--;
        }
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next;
            slowPointer = (slowPointer == null) ? head :slowPointer.next;
        }
        if(slowPointer == null){
            head = head.next;
        } else {
            slowPointer.next = slowPointer.next.next;
        }
        return head;
    }
}

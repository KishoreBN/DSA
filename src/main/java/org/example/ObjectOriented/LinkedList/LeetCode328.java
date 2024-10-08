package org.example.ObjectOriented.LinkedList;

public class LeetCode328 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(2);
        list.insert(1);
        list.insert(3);
        list.insert(2);
        list.insert(5);
        list.insert(2);
        Utility.printLinkedList(oddEvenList(list.head));
    }

    public static Node oddEvenList(Node head) {
        Node firstHead = new Node(-111), firstTail = firstHead, secondHead = new Node(-111), secondTail = secondHead;
        int count = 1;
        while(head != null){
            if((count & 1) == 1){
                firstTail.next = head;
                firstTail = firstTail.next;
            } else {
                secondTail.next = head;
                secondTail = secondTail.next;
            }
            head = head.next;
            count++;
        }
        firstTail.next = secondHead.next;
        secondTail.next = null;
        return firstHead.next;
    }
}

package org.example.ObjectOriented.LinkedList;

public class LeetCode86 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(2);
        list.insert(1);
//        list.insert(3);
//        list.insert(2);
//        list.insert(5);
//        list.insert(2);
        Utility.printLinkedList(partition(list.head, 2));
    }

    public static Node partition(Node head, int x) {
        Node firstHead = new Node(-111), firstTail = firstHead, secondHead = new Node(-111), secondTail = secondHead;
        while(head != null){
            if((int)head.value < x){
                firstTail.next = head;
                firstTail = firstTail.next;
            } else {
                secondTail.next = head;
                secondTail = secondTail.next;
            }
            head = head.next;
        }
        secondTail.next = null;
        firstTail.next = secondHead.next;
        return firstHead.next;
    }
}

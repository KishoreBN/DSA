package org.example.ObjectOriented.LinkedList;

public class LeetCode82 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(0);
        list.insert(0);
        list.insert(0);
        list.insert(0);
        list.insert(3);
        Utility.printLinkedList(deleteDuplicates(list.head));
    }

    public static Node deleteDuplicates(Node head) {
        Node dummyHead = new Node();
        Node dummyTail = dummyHead;
        Node prevNode = null;
        while(head != null){
            if(dummyTail.value == head.value){
                while(head != null && head.value == dummyTail.value){
                    head = head.next;
                }
                dummyTail = prevNode;
            } else {
                dummyTail.next = head;
                prevNode = dummyTail;
                dummyTail = dummyTail.next;
                head = head.next;
            }
        }
        dummyTail.next = null;
        return dummyHead.next;
    }
}

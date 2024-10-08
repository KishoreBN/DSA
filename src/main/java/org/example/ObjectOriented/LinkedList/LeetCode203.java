package org.example.ObjectOriented.LinkedList;

public class LeetCode203 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        Utility.printLinkedList(removeElements(list.head, 6));
    }

    public static Node removeElements(Node head, int val) {
        Node dummyHead = new Node();
        dummyHead.next = head;
        Node prevNode = dummyHead;
        Node currentNode = head;
        while(currentNode != null){
            if((int)currentNode.value == val)
                prevNode.next = currentNode.next;
            else
                prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }
}

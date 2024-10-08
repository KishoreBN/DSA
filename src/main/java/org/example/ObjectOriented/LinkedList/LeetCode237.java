package org.example.ObjectOriented.LinkedList;

public class LeetCode237 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(2);
        list.insert(0);
        list.insert(1);
        list.insert(3);
        deleteNode(list.head.next);
        Utility.printLinkedList(list.head);
    }

    public static void deleteNode(Node node) {
        while(node != null && node.next.next != null){
            node.value = node.next.value;
            node = node.next;
        }
        node.value = node.next.value;
        node.next = null;
    }
}

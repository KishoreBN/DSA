package org.example.ObjectOriented.LinkedList;

public class MergeLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list1 = new CustomLinkedList<>();
        list1.insert(1);
        list1.insert(2);
        list1.insert(6);
        CustomLinkedList<Integer> list2 = new CustomLinkedList<>();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        Utility.printLinkedList(merge(list1.head, list2.head));
    }

    public static Node merge(Node left, Node right){
        Node head = new Node();
        Node tail = head;
        while(left != null && right != null){
            if((int)left.value < (int)right.value){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        tail.next = (left != null) ? left : right;
        return head.next;
    }
}

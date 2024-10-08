package org.example.ObjectOriented.LinkedList;

public class LeetCode61 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(0);
        list.insert(1);
        list.insert(2);
        Utility.printLinkedList(rotateRight(list.head, 4));
    }

    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 1;
        Node tail = head;
        while(tail != null && tail.next != null){
            tail = tail.next;
            count++;
        }
        tail.next = head;
        k = k % count;
        int moves = count - k;
        for(int i=0; i<moves; i++){
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}

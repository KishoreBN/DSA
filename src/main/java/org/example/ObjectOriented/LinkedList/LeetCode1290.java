package org.example.ObjectOriented.LinkedList;

public class LeetCode1290 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(0);
        list.insert(1);
        System.out.println(getDecimalValue(list.head));
    }

    public static int getDecimalValue(Node head) {
        StringBuilder str = new StringBuilder();
        while(head != null){
            str.append(head.value);
            head = head.next;
        }
        return Integer.parseInt(str.toString(), 2);
    }
}

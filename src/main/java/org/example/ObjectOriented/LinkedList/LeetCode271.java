package org.example.ObjectOriented.LinkedList;

public class LeetCode271 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        Utility.printLinkedList(swapNodes(list.head, 1));
    }

    public static Node swapNodes(Node head, int k) {
        Node slowPointer = head, fastPointer = head, firstPointer = null;
        int count = k;
        while(count > 0){
            firstPointer = (firstPointer == null) ? head : firstPointer.next;
            fastPointer = fastPointer.next;
            count--;
        }
        while(fastPointer != null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        int temp = (int) firstPointer.value;
        firstPointer.value = slowPointer.value;
        slowPointer.value = temp;
        return head;
    }
}

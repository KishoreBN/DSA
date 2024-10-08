package org.example.ObjectOriented.LinkedList;

public class LeetCode83 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(2);
        Utility.printLinkedList(deleteDuplicates(list.head));
    }

    public static Node deleteDuplicates(Node head) {
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }

}

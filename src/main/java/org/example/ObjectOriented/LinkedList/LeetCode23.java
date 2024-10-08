package org.example.ObjectOriented.LinkedList;

public class LeetCode23 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list1 = new CustomLinkedList<>();
        list1.insert(1);
        list1.insert(2);
        CustomLinkedList<Integer> list2 = new CustomLinkedList<>();
        list2.insert(1);
        list2.insert(2);
        Utility.printLinkedList(mergeKLists(new Node[]{list1.head,list2.head}));
    }

    public static Node mergeKLists(Node[] lists) {
        Node result = null;
        for(Node i : lists){
            result = merge(result, i);
        }
        return result;
    }

    public static Node merge(Node first, Node second){
        Node dummyHead = new Node(), dummyTail = dummyHead;
        while(first != null && second != null){
            if((int)first.value < (int)second.value){
                dummyTail.next = first;
                first = first.next;
            } else {
                dummyTail.next = second;
                second = second.next;
            }
            dummyTail = dummyTail.next;
        }
        dummyTail.next = first == null ? second : first;
        return dummyHead.next;
    }
}

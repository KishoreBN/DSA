package org.example.ObjectOriented.LinkedList;

public class LeetCode21 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list1 = new CustomLinkedList<>();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        CustomLinkedList<Integer> list2 = new CustomLinkedList<>();
//        list2.insert(1);
//        list2.insert(4);
//        list2.insert(6);
//        list2.insert(8);

        Utility.printLinkedList(mergeTwoLists(list1.head, list2.head));
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        Node resultHead = null;
        Node resultTail = null;
        while(list1 != null && list2 != null){
            Node node = new Node();
            if((int)list1.value < (int)list2.value){
                node.value = list1.value;
                list1 = list1.next;
            } else {
                node.value = list2.value;
                list2 = list2.next;
            }
            if(resultHead == null){
                resultHead = node;
                resultTail = node;
            }
            resultTail.next = node;
            resultTail = node;
        }
        if(list1 != null){
            resultTail.next = list1;
        }
        if(list2 != null){
            resultTail.next = list2;
        }
        return resultHead;
    }
}

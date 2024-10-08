package org.example.ObjectOriented.LinkedList;

public class LeetCode148 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        Utility.printLinkedList(sortList(list.head));
    }

    public static Node sortList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node mid = midNode(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return merge(left, right);
    }


    public static Node midNode(Node head){
       Node midPrev = null;
       while(head != null && head.next != null){
           midPrev = (midPrev == null) ? head : midPrev.next;
           head = head.next.next;
       }
       Node mid = midPrev.next;
       midPrev.next = null;
       return mid;
    }

    public static Node merge(Node leftHead, Node rightHead){
        Node head = new Node();
        Node tail = head;
        while(leftHead != null && rightHead != null){
            if((int)leftHead.value < (int)rightHead.value){
                tail.next = leftHead;
                leftHead = leftHead.next;
                tail = tail.next;
            } else {
                tail.next = rightHead;
                rightHead = rightHead.next;
                tail = tail.next;
            }
        }
        tail.next = (leftHead != null) ? leftHead : rightHead;
        return head.next;
    }
}

package org.example.ObjectOriented.LinkedList;

public class LeetCode206 {
    static Node newHead;
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(5);
        list.insert(4);
        list.insert(8);
        list.insert(2);
        list.insert(1);
        list.insert(10);
        Utility.printLinkedList(reverseInPlace(list.head));
    }

    public static Node reverseList(Node head) {
        if(head == null || head.next == null){
            newHead = head;
            return head;
        }
        Node newTail = reverseList(head.next);
        newTail.next = head;
        head.next = null;
        newTail = head;
        return newTail;
    }

    public static Node helper(Node head){
        if(head == null || head.next == null){
            newHead = head;
            return head;
        }
        Node newTail = helper(head.next);
        newTail.next = head;
        head.next = null;
        newTail = head;
        return newTail;
    }

    public static Node reverseInPlace(Node head){
        Node prevNode = null, currentNode = head, nextNode = head.next;
        while(currentNode != null){
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return prevNode;
    }
}

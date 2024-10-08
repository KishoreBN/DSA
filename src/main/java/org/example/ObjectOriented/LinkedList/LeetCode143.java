package org.example.ObjectOriented.LinkedList;

public class LeetCode143 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(5);
        reorderList(list.head);
        Utility.printLinkedList(list.head);
    }

    public static void reorderList(Node head) {
        if(head == null || head.next == null){
            return;
        }
        Node mid = midNode(head);
        Node reversedNode = reverse(mid);
        Node dummyHead = new Node(), tail = dummyHead;
        while (head != null && reversedNode != null){
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = reversedNode;
            reversedNode = reversedNode.next;
            tail = tail.next;
        }
    }

    public static Node midNode(Node head){
        Node slowPointer = head, fastPointer = head, midPrev = null;
        while(fastPointer != null && fastPointer.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        midPrev.next = null;
        return slowPointer;
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
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

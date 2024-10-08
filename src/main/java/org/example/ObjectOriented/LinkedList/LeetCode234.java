package org.example.ObjectOriented.LinkedList;

public class LeetCode234 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(2);
        list.insert(1);
        list.insert(1);
        list.insert(3);
        System.out.println(isPalindrome(list.head));
    }

    public static boolean isPalindrome(Node head) {
        Node mid = getMid(head);
        Node reversed = reverse(mid);
        while(head != null && reversed != null){
            if(head.value != reversed.value){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prevNode = null, currentNode = head, nextNode = head.next;
        while (currentNode != null){
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return prevNode;
    }

    public static Node getMid(Node head){
        Node fastPointer = head, slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}

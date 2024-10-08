package org.example.ObjectOriented.LinkedList;

public class LeetCode25 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        Utility.printLinkedList(reverseAlternate(list.head, 3));
    }

    public static Node reverseKGroup(Node head, int k) {
        int length = getLength(head);
        if(length == 0)
            return head;
        int iterations = length/k;
        for(int i=0; i< iterations; i++){
            head = reverse(head, (k * i) + 1, (k * i) + k);
        }
        return head;
    }

    public static Node reverseAlternate(Node head, int k){
        int length = getLength(head);
        if(length == 0){
            return head;
        }
        int iterations = length/k;
        for(int i=0; i<iterations; i++){
            if((i & 1) == 0) head = reverse(head, (i * k) + 1, (k * i) + k);
        }
        return head;
    }

    public static Node reverse(Node head, int left, int right){
        if(head == null || head.next == null || left == right){
            return head;
        }
        Node prevNode = null, currentNode = head;
        for(int i=0; i<left-1 && currentNode != null; i++){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        Node leftParent = prevNode, newEnd = currentNode, nextNode = currentNode.next;
        for(int i=0; i<(right - left + 1) && currentNode != null; i++){
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null)
                nextNode = nextNode.next;
        }
        if(leftParent != null){
            leftParent.next = prevNode;
        } else {
            head = prevNode;
        }
        newEnd.next = currentNode;
        return head;
    }

    public static int getLength(Node head){
        if(head == null)
            return 0;
        int count = 1;
        while(head != null && head.next != null){
            head = head.next;
            count++;
        }
        return count;
    }

}

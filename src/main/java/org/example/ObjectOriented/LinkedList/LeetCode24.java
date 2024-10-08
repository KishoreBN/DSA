package org.example.ObjectOriented.LinkedList;

public class LeetCode24 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        Utility.printLinkedList(swapPairs(list.head));
    }

    public static Node swapPairs(Node head) {
        int length = getLenght(head), count = 0;
        while(count < length/2){
            int left = count * 2 + 1;
            head = reverseK(head, left, left + 1);
            count++;
        }
        return head;
    }

    public static Node reverseK(Node head, int left, int right){
        if(head == null || head.next == null || left == right){
            return head;
        }
        Node prevNode = null, currentNode = head;
        for(int i=0; i<left-1 && currentNode != null; i++){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        Node leftParent = prevNode, newEnd = currentNode, nextNode = currentNode.next;
        for(int i=0; i<right - left + 1 && currentNode != null; i++){
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        newEnd.next = currentNode;
        if(leftParent == null){
            head = prevNode;
        } else {
            leftParent.next = prevNode;
        }
        return head;
    }

    public static int getLenght(Node head){
        if(head == null)
            return 0;
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}

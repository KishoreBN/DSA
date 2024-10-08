package org.example.ObjectOriented.LinkedList;

public class LeetCode92 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(3);
        list.insert(5);
        Utility.printLinkedList(reverseBetween(list.head, 1, 2));
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        Node currentNode = head, prevNode = null;
        for(int i=0; i<left-1 && currentNode != null; i++){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        Node leftParent = prevNode, newEnd = currentNode, nextNode = currentNode.next;
        for(int i=0; i<(right - left + 1) && currentNode != null; i++){
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        if(leftParent != null) {
            leftParent.next = prevNode;
        } else {
            head = prevNode;
        }
        newEnd.next = currentNode;
        return head;
    }

}

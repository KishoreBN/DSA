package org.example.ObjectOriented.LinkedList;

public class LeetCode147 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(-1);
        list.insert(5);
        list.insert(3);
        list.insert(4);
        list.insert(0);
        Utility.printLinkedList(insertionSortList(list.head));
    }

    public static Node insertionSortList(Node head) {
        Node prevNode = null, iterationHead = head;
        int count = 0;
        while(iterationHead != null){
            int correctIndex = findCorrectIndex(head, iterationHead);
            if(correctIndex != count){
                removeNode(prevNode, iterationHead);
                head = insertNode(head, iterationHead, correctIndex);
                iterationHead = prevNode.next;
            } else {
                prevNode = iterationHead;
                iterationHead = iterationHead.next;
            }
            count++;
        }
        return head;
    }

    public static int findCorrectIndex(Node head, Node node){
        int index = 0;
        while(head != null && head.next != null && (int)head.value < (int)node.value && head != node){
            head = head.next;
            index++;
        }
        return index;
    }

    public static void removeNode(Node prevNode, Node currentNode){
        if(currentNode != null){
            prevNode.next = currentNode.next;
        }
    }

    public static Node insertNode(Node head, Node node, int index){
        Node dummyHead = new Node();
        Node prevNode = dummyHead;
        for(int i=0; i<index; i++){
            if(prevNode.next == null){
                prevNode.next = head;
            }
            prevNode = prevNode.next;
        }
        if(prevNode.next == null){
            node.next = head;
        } else {
            node.next = prevNode.next;
        }
        prevNode.next = node;
        return dummyHead.next;
    }
}

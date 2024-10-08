package org.example.ObjectOriented.LinkedList;

public class LeetCode726 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        Node[] result = splitListToParts(list.head, 3);
        for(Node i : result){
            Utility.printLinkedList(i);
        }
    }

    public static Node[] splitListToParts(Node head, int k) {
        int length = getLenght(head), extraElement = length % k, resultIndex = 0, indvLength = length/k;
        Node[] arr = new Node[k];
        for(int i=0; i<length && head != null; i++){
            Node dummyHead = head, tail = null;
            int count = 0;
            while(count < indvLength && head != null){
                tail = (tail == null) ? head : tail.next;
                head = head.next;
                count++;
            }
            if(extraElement > 0){
                tail = tail == null ? head : tail.next;
                head = head.next;
                extraElement--;
            }
            tail.next = null;
            arr[resultIndex] = dummyHead;
            resultIndex++;
        }
        return arr;
    }

    public static int getLenght(Node head){
        if(head == null){
            return 0;
        }
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}

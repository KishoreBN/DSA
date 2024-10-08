package org.example.ObjectOriented.LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(1));

        CustomDoubleLinkedList<Integer> listD = new CustomDoubleLinkedList<>();
        listD.insert(1);
        listD.insert(2);
        listD.insert(0);
        listD.insert(4);
        listD.remove(3);
        System.out.println(listD);

        System.out.println("Circular Linked list...");
        CircularLinkedList<Integer> listC = new CircularLinkedList<>();
        listC.insert(1);
        listC.insert(2);
        listC.insert(3);
        System.out.println(listC);
        listC.remove(3);
        System.out.println(listC);

        System.out.println("Recursion insert");
        CustomLinkedList<Integer> listR = new CustomLinkedList<>();
        listR.insertUsingRecursion(0, 1);
        listR.insertUsingRecursion(1,2);
        listR.insertUsingRecursion(2, 3);
        System.out.println(listR);

    }
}

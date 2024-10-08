package org.example.BinaryTree;

import java.util.Scanner;

public class CustomBinaryTree {
    Node root;
    int size;

    Scanner sc;

    CustomBinaryTree(){}
    public void populate(){
        sc = new Scanner(System.in);
        System.out.println("Enter the root node : ");
        root = new Node(sc.nextInt());
        populateChildNodes(root);
    }

    private void populateChildNodes(Node parent){
        System.out.println("Do you want to insert to the left of " + parent.value + " node ?");
        boolean bool = sc.nextBoolean();
        if(bool){
            System.out.println("Enter the left of " + parent.value + " node : ");
            Node left = new Node(sc.nextInt());
            parent.left = left;
            populateChildNodes(left);
        }
        System.out.println("Do you want to insert to the right of " + parent.value + " node ?");
        bool = sc.nextBoolean();
        if(bool){
            System.out.println("Enter the right of " + parent.value + " node : ");
            Node right = new Node(sc.nextInt());
            parent.right = right;
            populateChildNodes(right);
        }
    }
}

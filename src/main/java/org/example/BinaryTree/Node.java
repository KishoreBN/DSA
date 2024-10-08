package org.example.BinaryTree;

public class Node {
    public int value;
    public Node left;
    public Node right;
    public int height = 1;
    Node(int value){
        this.value = value;
    }
    Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public int height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }
}

package org.example.BinaryTree;

public class LeetCode226 {
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(10);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(3);
        tree.insertNode(7);
        System.out.println(tree.inOrderTraversal());
        invertTree(tree.root);
        System.out.println(tree.inOrderTraversal());
    }

    public static Node invertTree(Node root) {
        return helper(root);
    }

    public static Node helper(Node node){
        if(node == null)
            return node;
        Node temp = helper(node.left);
        node.left = helper(node.right);
        node.right = temp;
        return node;
    }
}

package org.example.BinaryTree;

public class LeetCode114 {
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(20);
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(25);
        tree.insertNode(35);
        System.out.println(tree.preOrderTraversal());
        flatten(tree.root);
        System.out.println(tree.preOrderTraversal());
    }

    public static void flatten(Node root) {
        if(root == null){
            return;
        }
        Node node = root;
        while (node != null){
            if(node.left != null){
                Node temp = node.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}

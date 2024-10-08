package org.example.BinaryTree;

public class LeetCode104 {
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(10);
        tree.insertNode(5);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(25);
        System.out.println(maxDepth(tree.root));
    }

    public static int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return height;
    }
}

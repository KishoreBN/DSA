package org.example.BinaryTree;

public class LeetCode110 {
    public static boolean result = true;
    public static void main(String[] args) {

    }

    public static boolean isBalanced(Node root) {
        height(root);
        return result;
    }

    public static int height(Node node){
        if(node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            result = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

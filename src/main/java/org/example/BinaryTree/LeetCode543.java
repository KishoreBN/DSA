package org.example.BinaryTree;

public class LeetCode543 {
    static int longestPath = Integer.MIN_VALUE;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(10);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(3);
        tree.insertNode(7);
        System.out.println(diameterOfBinaryTree(tree.root));
    }

    public static int diameterOfBinaryTree(Node root) {
        helper(root);
        return longestPath;
    }

    public static int helper(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        longestPath = Math.max(longestPath, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

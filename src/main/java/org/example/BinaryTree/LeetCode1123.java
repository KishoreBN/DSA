package org.example.BinaryTree;

public class LeetCode1123 {
    public static int maxRow = 0;
    public static Node parent = null;
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 55, 85, 30, 45};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(lcaDeepestLeaves(tree.root).value);
    }

    public static Node lcaDeepestLeaves(Node root) {
        helper(root, 1, true);
        return parent;
    }

    public static void helper(Node node, int row, boolean isPossible){
        if(node == null)
            return;
        if((row > maxRow && (node.left != null && node.right != null)) || (row > maxRow && isPossible)){
            maxRow = row;
            parent = node;
        }
        helper(node.left, row + 1, (node.left == null || node.right == null));
        helper(node.right, row + 1, (node.left == null || node.right == null));
    }
}

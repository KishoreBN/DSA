package org.example.BinaryTree;

public class LeetCode112 {
    public static boolean result = false;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        tree.insertNode(10);
        tree.insertNode(30);
        System.out.println(hasPathSum(tree.root, 10));
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if(root == null)
            return false;
        if(root.value == targetSum && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right, targetSum - root.value);
    }

    public static void hasPathSum(Node root, Node node, int targetSum, int sum){
        if(node == null){
            return;
        }
        sum += node.value;
        if(sum == targetSum && node.left == null && node != root){
            result = true;
        }
        hasPathSum(root, node.left, targetSum, sum);
        hasPathSum(root, node.right, targetSum, sum);
    }
}

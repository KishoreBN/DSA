package org.example.BinaryTree;

public class LeetCode111 {
    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(20);
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(25);
        tree.insertNode(35);
        System.out.println(minDepth(tree.root));
    }

    public static int minDepth(Node root) {
        minDepth(root, 0);
        return result;
    }

    public static void minDepth(Node node, int count){
        if(node == null)
            return;
        count++;
        if(node.left == null && node.right == null)
            result = Math.min(result, count);
        minDepth(node.left, count);
        minDepth(node.right, count);
    }
}

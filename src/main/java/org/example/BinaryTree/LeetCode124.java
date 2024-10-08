package org.example.BinaryTree;

import java.rmi.MarshalException;

public class LeetCode124 {
    public static int result = 0;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(2);
        tree.insertNode(-1);
//        tree.insertNode(3);
        System.out.println(maxPathSum(tree.root));
    }

    public static int maxPathSum(Node root) {
        int val = helper(root);
        return Math.max(val, result);
    }

    public static int helper(Node node){
        if(node == null){
            return 0;
        }
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        result = Math.max(result, leftMax + rightMax + node.value);
        return node.value + Math.max(leftMax, rightMax);
    }

}


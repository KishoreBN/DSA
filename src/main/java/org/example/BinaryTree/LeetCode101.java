package org.example.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode101 {
    public static void main(String[] args) {
        System.out.println(null == null);
    }

    public static boolean isSymmetric(Node root) {
        return helper(root.left, root.right);
    }

    public static boolean helper(Node node1, Node node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.value != node2.value) return false;
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}

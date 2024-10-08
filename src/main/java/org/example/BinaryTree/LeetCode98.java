package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode98 {
    public static boolean isValid = true;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        tree.insertNode(0);
//        tree.insertNode(30);
//        tree.insertNode(5);
//        tree.insertNode(15);
//        tree.insertNode(25);
//        tree.insertNode(35);
        System.out.println(isValidBST(tree.root));
    }

    public static boolean isValidBST(Node root) {
        List<Integer> list = new ArrayList<>();
        helper2(root, Long.MIN_VALUE);
        return isValid;
    }

    public static void helper(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        helper(node.left, list);
        if(list.size() > 1 && node.value < list.get(list.size() - 1)){
            isValid = false;
        }
        list.add(node.value);
        helper(node.right, list);
    }

    public static void helper2(Node node, long previousNum){
        if(node == null)
            return;
        helper2(node.left, previousNum);
        if(node.value <= previousNum){
            isValid = false;
        }
        previousNum = node.value;
        helper2(node.right, previousNum);
    }

}

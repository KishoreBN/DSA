package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode545 {
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 10, 1, 100, 20, 80, 15, 22, 77, 89};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(getBoundary(tree.root));
    }

    public static List<Integer> getBoundary(Node root){
        List<Integer> result = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        addLeftBoundary(root, result);
        addLeafNodes(root, result);
        addRightBoundary(root, right);
        Collections.reverse(right);
        result.addAll(right);
        return result;
    }

    public static void addLeftBoundary(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left != null || root.right != null) {
            list.add(root.value);
        }
        addLeftBoundary(root.left, list);
        if(root.left == null)
            addLeftBoundary(root.right, list);
    }

    public static void addRightBoundary(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left != null || root.right != null) {
            list.add(root.value);
        }
        addRightBoundary(root.right, list);
        if(root.right == null)
            addRightBoundary(root.left, list);
    }

    public static void addLeafNodes(Node root, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.add(root.value);
        addLeafNodes(root.left, list);
        addLeafNodes(root.right, list);
    }
}

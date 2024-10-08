package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode230 {

    public static int count = 0;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(20);
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(25);
        tree.insertNode(35);
        tree.insertNode(17);
        System.out.println(kthSmallest(tree.root, 2));
    }

    public static int kthSmallest(Node root, int k) {
        List<Integer> list = new ArrayList<>();
//        helper(root, list);
        return helper2(root, k).value;
//        return list.get(k - 1);
    }

    public static void helper(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        helper(node.left, list);
        list.add(node.value);
        helper(node.right, list);
    }

    public static Node helper2(Node node, int k){
        if(node == null){
            return node;
        }
        Node left = helper2(node.left, k);
        if(left != null){
            return left;
        }
        count++;
        if(count == k){
            return node;
        }
        return helper2(node.right, k);
    }
}

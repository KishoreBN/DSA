package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 65, 85};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(Paths(tree.root));
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(root, result, new ArrayList<>());
        return result;
    }

    public static void helper(Node node, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> processed){
        if(node == null)
            return;
        processed.add(node.value);
        if(node.left == null && node.right == null){
            list.add(new ArrayList<>(processed));
        }
        helper(node.left, list, processed);
        helper(node.right, list, processed);
        processed.remove(processed.size() - 1);
    }
}

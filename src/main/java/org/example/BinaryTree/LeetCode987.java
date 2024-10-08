package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode987 {
    public static int minColumn = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 65};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(verticalTraversal(tree.root));
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<NodeWrapper>> result = new ArrayList<>();
        helper(root, result, 0, 0);
        List<List<Integer>> finalResult = new ArrayList<>();
        for(List<NodeWrapper> subList : result){
            List<Integer> sub = new ArrayList<>();
            sub.addAll(subList.stream().map(i -> i.value).collect(Collectors.toList()));
            finalResult.add(sub);
        }
        return finalResult;
    }

    public static void helper(Node node, List<List<NodeWrapper>> list, int column, int row){
        if(node == null){
            return;
        }
        minColumn = Math.min(column, minColumn);
        helper(node.left, list, column - 1, row + 1);
        int index = column - (minColumn);
        if(list.size() <= index){
            List<NodeWrapper> subList = new ArrayList<>();
            subList.add(new NodeWrapper(node.value, row, column));
            list.add(subList);
        } else {
            List<NodeWrapper> subList = list.get(index);
            subList.add(new NodeWrapper(node.value, row, column));
            subList.sort(Comparator.comparingInt((NodeWrapper d) -> d.row).thenComparing(d -> d.value));
        }
        helper(node.right, list, column + 1, row + 1);
    }
}

package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode863 {
    public static Integer targetRow = null, targetCol = null;
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 65};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(distanceK(tree.root, tree.root,  1));
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Node, Node> map = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap();
        map.put(root, null);
        populateParent(root, map);
        helper(target, k + 1, result, map, visited);
        return result;
    }

    public static void helper(Node node, int k, List<Integer> list, Map<Node, Node> map, Map<Node, Boolean> visited){
        if(node == null)
            return;
        k--;
        if(k == 0)
            list.add(node.value);
        visited.put(node, true);
        if(visited.get(node.left) == null) {
            helper(node.left, k, list, map, visited);
        }
        if(visited.get(node.right) == null) {
            helper(node.right, k, list, map, visited);
        }
        if(visited.get(map.get(node)) == null) {
            helper(map.get(node), k, list, map, visited);
        }
    }

    public static void populateParent(Node node, Map<Node, Node> map){
        if(node == null)
            return;
        if(node.left != null)
            map.put(node.left, node);
        if(node.right != null)
            map.put(node.right, node);
        populateParent(node.left, map);
        populateParent(node.right, map);
    }

}

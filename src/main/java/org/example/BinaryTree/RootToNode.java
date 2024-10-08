package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 65, 85};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(pathToNode(tree.root, 75));
    }

    public static List<Integer> pathToNode(Node root, int target){
        List<Integer> result = new ArrayList<>();
        helper(root, result, target);
        return result;
    }

    public static boolean helper(Node node, List<Integer> list, int target){
        if(node == null)
            return false;
        if(node.value == target){
            list.add(node.value);
            return true;
        }
        list.add(node.value);
        boolean left = helper(node.left, list, target);
        boolean right = left || helper(node.right, list, target);
        if(!right && !left)
            list.remove(list.size() - 1);
        return left || right;
    }
}

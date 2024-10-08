package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewBT {
    public static void main(String[] args) {
        int[] arr = {50, 75, 25, 15, 35, 65};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(rightView(tree.root));
    }

    public static List<Integer> rightView(Node root){
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(Node node, List<Integer> list, int row){
        if(node == null)
            return;
        if(list.size() <= row) {
            list.add(node.value);
        }
        rightView(node.right, list, row + 1);
        rightView(node.left, list, row + 1);
    }
}

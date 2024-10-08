package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewBT {
    public static void main(String[] args) {

    }

    public static List<Integer> leftView(Node root){
        List<Integer> result = new ArrayList<>();
        leftView(root, result, 0);
        return result;
    }

    public static void leftView(Node node, List<Integer> list, int row){
        if(node == null)
            return;
        if(list.size() <= row){
            list.add(node.value);
        }
        leftView(node.left, list, row + 1);
        leftView(node.right, list, row + 1);
    }
}

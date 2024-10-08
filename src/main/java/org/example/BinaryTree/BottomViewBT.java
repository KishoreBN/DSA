package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BottomViewBT {
    public static int minColumn = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] arr = {50, 75, 25, 15, 35, 65};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(bottomView(tree.root));
    }

    public static List<Integer> bottomView(Node root){
        List<NodeWrapper> result = new ArrayList<>();
        bottomView(root, result, 0, 0);
        return result.stream().map(i -> i.value).collect(Collectors.toList());
    }

    public static void bottomView(Node node, List<NodeWrapper> list, int column, int row){
        if(node == null)
            return;
        minColumn = Math.min(minColumn, column);
        bottomView(node.left, list, column - 1, row + 1);
        int index = column - (minColumn);
        if(list.size() <= index){
            list.add(new NodeWrapper(node.value, row, column));
        } else {
            NodeWrapper existingNode = list.get(index);
            if(existingNode.row < row){
                list.set(index, new NodeWrapper(node.value, row, column));
            }
        }
        bottomView(node.right, list, column + 1, row + 1);
    }
}

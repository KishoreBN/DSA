package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(3);
        tree.insertNode(9);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(7);
        System.out.println(levelOrder(tree.root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if(root == null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                subList.add(node.value);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(subList.size() > 0)
                result.add(subList);
        }
        return result;
    }
}

package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(15);
        tree.insertNode(10);
        tree.insertNode(20);
        tree.insertNode(1);
        tree.insertNode(11);
        tree.insertNode(19);
        tree.insertNode(21);
        System.out.println(zigzagLevelOrder(tree.root));
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        boolean leftToRight = true;
        if(root == null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = leftToRight ? queue.poll() : queue.pollLast();
                subList.add(node.value);
                if(leftToRight){
                    if(node.left != null)
                        queue.offer(node.left);
                    if(node.right != null)
                        queue.offer(node.right);
                } else {
                    if(node.right != null)
                        queue.offerFirst(node.right);
                    if(node.left != null)
                        queue.offerFirst(node.left);
                }
            }
            leftToRight = !leftToRight;
            result.add(subList);
        }
        return result;
    }
}

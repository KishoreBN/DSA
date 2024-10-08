package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.insertNode(15);
        avl.insertNode(10);
        avl.insertNode(20);
        avl.insertNode(1);
        avl.insertNode(11);
        avl.insertNode(16);
        avl.insertNode(22);
        System.out.println(avl.inOrderTraversal());
    }

    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root){
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            Node node = leftToRight ? queue.poll() : queue.pollFirst();
            subList.add(node.value);
            for(int i=0; i<size; i++){
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

package org.example.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode993 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(50);
        tree.insertNode(25);
        tree.insertNode(75);
        tree.insertNode(10);
        tree.insertNode(65);
        System.out.println(isCousins(tree.root, 65, 10));
    }

    public static boolean isCousins(Node root, int x, int y) {
        if(root == null)
            return false;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isXpresent = false;
            boolean isYpresent = false;
            for(int i=0; i<size; i++) {
                Node node = queue.poll();
                if (node.left != null && node.right != null &&
                        ((node.left.value == x && node.right.value == y) || (node.left.value == y && node.right.value == x)))
                    return false;
                if (node.left != null) {
                    if (node.left.value == x)
                        isXpresent = true;
                    if (node.left.value == y)
                        isYpresent = true;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.value == x)
                        isXpresent = true;
                    if (node.right.value == y)
                        isYpresent = true;
                    queue.offer(node.right);
                }
                if (isXpresent && isYpresent)
                    return true;
            }
            isXpresent = false;
            isYpresent = false;
        }
        return false;
    }
}

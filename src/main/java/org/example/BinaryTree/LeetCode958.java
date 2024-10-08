package org.example.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode958 {
    public static boolean result = true;
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 65, 85};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(isCompleteTree(tree.root));
    }

    public static boolean isCompleteTree(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNullFound = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                if((isNullFound && node != null))
                    return false;
                if(node != null)
                    queue.offer(node.left);
                if(node != null)
                    queue.offer(node.right);
                if(node == null)
                    isNullFound = true;
            }
        }
        return true;
    }

}

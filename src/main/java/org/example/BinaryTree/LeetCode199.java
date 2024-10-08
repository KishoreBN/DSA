package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {
    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                if(i == size - 1){
                    list.add(node.value);
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return list;
    }
}

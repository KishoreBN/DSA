package org.example.BinaryTree;

import java.util.*;

public class LeetCode637 {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(Node root) {
        List<Double> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if(root == null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double average = 0;
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                average += node.value;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            average = average/size;
            result.add(average);
        }
        return result;
    }
}

package org.example.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode662 {
    public static void main(String[] args) {
        int[] arr = {50};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
        System.out.println(widthOfBinaryTree(tree.root));
    }

    public static int widthOfBinaryTree(Node root) {
        Deque<NodeWrap> queue = new LinkedList<>();
        queue.offer(new NodeWrap(root, 1));
        int maxDiff = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            NodeWrap firstEle = null;
            for(int i=0; i<size; i++){
                NodeWrap wrap = queue.poll();
                if(i == 0) {
                    firstEle = wrap;
                }
                maxDiff = Math.max(maxDiff, wrap.col - firstEle.col + 1);
                if(wrap.node.left != null){
                    queue.offer(new NodeWrap(wrap.node.left, 2*wrap.col - 1));
                }
                if(wrap.node.right != null){
                    queue.offer(new NodeWrap(wrap.node.right, 2*wrap.col));
                }
            }
        }
        return maxDiff;
    }
}

class NodeWrap{
    Node node;
    int col;

    NodeWrap(Node node, int col){
        this.node = node;
        this.col = col;
    }
}

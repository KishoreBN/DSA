//package org.example.BinaryTree;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class LeetCode116 {
//    public static void main(String[] args) {
//
//    }
//
//    public static Node connect(Node root) {
//        Deque<Node> queue = new LinkedList<>();
//        if(root == null)
//            return root;
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            Node node;
//            for(int i=0; i<size; i++){
//                node = queue.poll();
//                node.next = queue.isEmpty() ? null : queue.peekFirst();
//                if(node.left != null)
//                    queue.offer(node.left);
//                if(node.right != null)
//                    queue.offer(node.right);
//            }
//            node.next = null;
//        }
//        return root;
//    }
//
//    public static Node helper(Node root){
//        if(root == null)
//            return root;
//        Node leftMostNode = root;
//        while (leftMostNode != null){
//            Node currentNode = leftMostNode;
//            while (currentNode != null) {
//                if(currentNode.left != null){
//                    currentNode.left.next = currentNode.right;
//                    if(currentNode.next != null) {
//                        currentNode.right.next = currentNode.next.left;
//                    }
//                }//                currentNode = currentNode.next;
//            }
//            leftMostNode = leftMostNode.left;
//        }
//        return root;
//    }
//}

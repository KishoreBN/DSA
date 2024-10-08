package org.example.BinaryTree;

import java.util.*;

public class CustomBST {
    Node root;

    Boolean isBalanced;
    CustomBST(){};
    CustomBST(int value){
        this.root = new Node(value);
    }

    /**
     * Inserts the value in Log(N) time complexity.
     * @param value
     */
    public void insertNode(int value){
        root = insertNode(value, root);
    }

    private Node insertNode(int value, Node node){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insertNode(value, node.left);
        } else {
            node.right = insertNode(value, node.right);
        }
        node.height = Math.max(node.height(node.left), node.height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(node.height(node.left) - node.height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * N -> L -> R
     * Use cases: Copying Tree
     * @return
     */
    public List<Integer> preOrderTraversal(){
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.value);
        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

    /**
     * L -> N -> R
     * @return
     */
    public List<Integer> inOrderTraversal(){
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.value);
        inOrderTraversal(node.right, list);
    }

    /**
     * L -> N -> R
     * @return
     */
    public List<Integer> postOrderTraversal(){
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        postOrderTraversal(node.left, list);
        postOrderTraversal(node.right, list);
        list.add(node.value);
    }

    public List<Integer> bfsTraversal(){
        List<Integer> list = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            if(queue.peekFirst() != null){
                Node node = queue.pollFirst();
                list.add(node.value);
                queue.offerLast(node.left);
                queue.offerLast(node.right);
            } else{
                queue.pollFirst();
            }
        }
        return list;
    }
}

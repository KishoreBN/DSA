package org.example.BinaryTree;

import java.util.*;

public class AVLTree {
    Node root;
    AVLTree(){};

    int height;
    AVLTree(int value){
        this.root = new Node(value);
    }

    public void insertNode(int value){
        root = insertNode(root, value);
        height = root.height;
    }

    private Node insertNode(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insertNode(node.left, value);
        } else {
            node.right = insertNode(node.right, value);
        }
        node = rotate(node);
        node.height = Math.max(node.height(node.left), node.height(node.right)) + 1;
        return node;
    }

    private Node rotate(Node node){
        if (node.height(node.left) - node.height(node.right) > 1) {
            // left heavy
            if(node.height(node.left.left) - node.height(node.left.right) > 0) {
                // left left case
                return rotateRight(node);
            }
            if(node.height(node.left.left) - node.height(node.left.right) < 0) {
                // left right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (node.height(node.left) - node.height(node.right) < -1) {
            // right heavy
            if(node.height(node.right.left) - node.height(node.right.right) < 0) {
                // right right case
                return rotateLeft(node);
            }
            if(node.height(node.right.left) - node.height(node.right.right) > 0) {
                // left right case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    private Node rotateRight(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(p.height(p.left), p.height(p.right)) + 1;
        c.height = Math.max(c.height(c.left), c.height(c.right)) + 1;
        return c;
    }

    private Node rotateLeft(Node c){
        Node p = c.right;
        Node t = p.left;
        c.right = t;
        p.left = c;
        c.height = Math.max(c.height(c.left), c.height(c.right)) + 1;
        p.height = Math.max(p.height(p.left), p.height(p.right)) + 1;
        return p;
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
     * Breath First Search (Breath First Traversal)
     * @return List<Integer>
     */
    public List<Integer> bfsTraversal(){
        List<Integer> list = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
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

    public List<Integer> preOrderTraversal(){
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()){
            if(stack.peek() != null){
                Node node = stack.pop();
                list.add(node.value);
                stack.push(node.right);
                stack.push(node.left);
            } else {
                stack.pop();
            }
        }
        return list;
    }

    public List<Integer> inOrderTraversal(){
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Node node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty())
                    break;
                Node prev = stack.pop();
                list.add(prev.value);
                node = prev.right;
            }
        };
        return list;
    }
}

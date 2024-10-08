package org.example.BinaryTree;

import java.util.*;

public class TraversalUsingStack {
    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(25);
        tree.insertNode(35);
        tree.insertNode(22);
        tree.insertNode(27);
        System.out.println(tree.preOrderTraversal());
        System.out.println(preOrderTraversal(tree.root));
        System.out.println(inOrderTraversal(tree.root));
        System.out.println(postOrderTraversal(tree.root));
    }

    public static List<Integer> preOrderTraversal(Node node){
        List<Integer> list = new ArrayList<>();
        if(node == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node n = stack.pop();
            list.add(n.value);
            if(n.right != null)
                stack.push(n.right);
            if(n.left != null)
                stack.push(n.left);
        }
        return list;
    }

    public static List<Integer> inOrderTraversal(Node node){
        List<Integer> list = new ArrayList<>();
        if(node == null)
            return list;
        Stack<Node> stack = new Stack<>();
        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()){
                    break;
                }
                Node n = stack.pop();
                list.add(n.value);
                node = n.right;
            }
        }
        return list;
    }

    /**
     * Using 2 Stacks
     * @param node
     * @return
     */
    public static List<Integer> postOrderTraversal(Node node){
        Stack<Node> stack1 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack1.push(node);
        while (!stack1.isEmpty()){
            Node n = stack1.pop();
            if(n.left != null)
                stack1.push(n.left);
            if(n.right != null)
                stack1.push(n.right);
            list.add(n.value);
        }
        Collections.reverse(list);
        return list;
    }
}

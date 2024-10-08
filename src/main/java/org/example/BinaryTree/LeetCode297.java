package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode297 {
    public static int index = 0;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(25);
        tree.insertNode(35);
        tree.insertNode(22);
        tree.insertNode(27);
        System.out.println((serialize(tree.root)));
        tree.root = deserialize(serialize(tree.root));
        System.out.println(tree.preOrderTraversal());
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list.toString();
        serialize(root, list);
        return list.toString();
    }

    public static void serialize(Node node, List<Integer> list){
        if(node == null) {
            list.add(null);
            return;
        }
        list.add(node.value);
        serialize(node.left, list);
        serialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        return deserialize(nodes);
    }

    public static Node deserialize(String[] nodes){
        if(nodes[index].trim().equals("null") || nodes[index].trim().equals("")){
            index++;
            return null;
        }
        Node node = new Node(Integer.parseInt(nodes[index].trim()));
        index++;
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }
}

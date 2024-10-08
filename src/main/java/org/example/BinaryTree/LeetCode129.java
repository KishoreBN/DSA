package org.example.BinaryTree;

public class LeetCode129 {
    public static int sum = 0;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST();
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(1);
        System.out.println(sumNumbers(tree.root));
    }

    public static int sumNumbers(Node root) {
        sumNumbers(root, 0);
        return sum;
    }

    public static void sumNumbers(Node node, int processed){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += (processed * 10) + node.value;
        }
        sumNumbers(node.left, (processed * 10) + node.value);
        sumNumbers(node.right, (processed * 10) + node.value);
    }
}

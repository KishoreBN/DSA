package org.example.BinaryTree;

public class LeetCode236 {
    public static Node result = null;
    public static void main(String[] args) {
        CustomBST tree = new CustomBST(20);
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(5);
        tree.insertNode(15);
        tree.insertNode(25);
        tree.insertNode(35);
        tree.insertNode(17);
        System.out.println(lowestCommonAncestor(tree.root, tree.root.left, tree.root.left.left).value);
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        helper2(root, p, q);
        return result;
    }

    public static boolean helper(Node node, Node p, Node q){
        if(node == null){
            return false;
        }
        boolean isPresentInLeft = helper(node.left, p, q);
        boolean isPresentInRight = helper(node.right, p, q);
        if((isPresentInRight && isPresentInLeft)
                || (isPresentInRight && (node.value == p.value || node.value == q.value))
                || (isPresentInLeft && (node.value == p.value || node.value == q.value))){
            result = node;
        }
        return (node.value == p.value || node.value == q.value || isPresentInRight || isPresentInLeft);
    }

    public static Node helper2(Node node, Node p, Node q){
        if(node == null)
            return null;
        if(node == p || node == q)
            return node;
        Node left = helper2(node.left, p, q);
        Node right = helper2(node.right, p, q);
        if(left != null && right != null)
            return node;
        return left == null ? right : left;
    }
}

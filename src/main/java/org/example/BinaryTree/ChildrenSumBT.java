package org.example.BinaryTree;

public class ChildrenSumBT {
    public static void main(String[] args) {
        CustomBinaryTree tree = new CustomBinaryTree();
        tree.populate();
        System.out.println(isSumProperty(tree.root));
    }

    public static int isSumProperty(Node root)
    {
        return helper(root) ? 1 : 0;
    }

    public static boolean helper(Node node){
        if(node == null || (node.left == null && node.right == null))
            return true;
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if(left == false || right == false)
            return false;
        return ((node.left == null ? 0 : node.left.value) + (node.right == null ? 0 : node.right.value) == node.value);
    }
}

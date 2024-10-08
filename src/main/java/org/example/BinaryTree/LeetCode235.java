package org.example.BinaryTree;

public class LeetCode235 {
    public static void main(String[] args) {
        int[] arr = {50, 25, 75, 15, 35, 55, 85, 30, 45};
        CustomBST tree = new CustomBST();
        for(int i : arr){
            tree.insertNode(i);
        }
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q)
            return root;
        if((p.value < root.value && q.value > root.value) || (p.value > root.value && q.value < root.value)){
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : left;
    }
}

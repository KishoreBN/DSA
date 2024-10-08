package org.example.BinaryTree;

import java.util.Arrays;

public class LeetCode105 {
    public static void main(String[] args) {

    }

    public Node buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        Node root = new Node(preorder[0]);
        int i = 0;
        while (i < inorder.length){
            if(inorder[i] == preorder[0])
                break;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i + 1));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }
}

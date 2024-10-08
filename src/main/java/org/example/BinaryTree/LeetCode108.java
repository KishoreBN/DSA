package org.example.BinaryTree;

public class LeetCode108 {
    static Node root = null;
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums).right.value);
    }

    public static Node sortedArrayToBST(int[] nums) {
        divideAndCondqueor(nums, 0, nums.length - 1);
        return root;
    }

    public static void divideAndCondqueor(int[] nums, int start, int end){
        if(start > end || end < start){
            return;
        }
        int mid = (end - start) % 2 == 0 ? start + (end - start)/2 : (start + (end - start)/2) + 1;
        root = insertNode(root, nums[mid]);
        divideAndCondqueor(nums, start, mid - 1);
        divideAndCondqueor(nums, mid + 1, end);
    }

    public static Node insertNode(Node node,int value){
        if(node == null){
            return new Node(value);
        }
        if(value > node.value){
            node.right = insertNode(node.right, value);
        } else {
            node.left = insertNode(node.left, value);
        }
        return node;
    }
}

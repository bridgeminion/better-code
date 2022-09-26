package top_interview_questions;

import common.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int rootIndex = nums.length/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIndex+1, nums.length));

        return root;
    }



}

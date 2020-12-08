package com.chad.leetcode.subject.easy;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
class MinimumDepthOfBinaryTree {

    /**
     * 思路:如果二叉树的左右子树的深度都不为0，也就是说左右子树都存在，则返回左右子树高度中的最小值+1.
     * 否则就是代表左右子树其中有一个为空或者都为空，则返回非空子树的高度+1.
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left!=0&&right!=0) return Math.min(left,right)+1;
        return left+right+1;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

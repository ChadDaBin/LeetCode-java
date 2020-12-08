package com.chad.leetcode.subject.easy;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 */
class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    private int getHeight(TreeNode treeNode){
        if(treeNode==null) return 0;
        int leftHeight = getHeight(treeNode.left);
        int rightHeight = getHeight(treeNode.right);
        return Math.max(leftHeight,rightHeight)+1;
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

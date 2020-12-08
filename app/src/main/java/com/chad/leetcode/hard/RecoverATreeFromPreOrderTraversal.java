package com.chad.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class RecoverATreeFromPreOrderTraversal {

    /**
     * 要注意到本题的关键是先序遍历，使用链表插入的方式。
     */
    public TreeNode recoverFromPreorder(String str) {
        char[] charsArray = str.toCharArray();
        int len = str.length(),i = 0;
        List<TreeNode> list = new LinkedList<>();
        while(i<len){
            int level = 0 , val = 0;//层级
            while(charsArray[i]=='-'){
                ++level;
                ++i;
            }
            while(i<len&&charsArray[i]!='-'){
                val = val * 10 + charsArray[i++] - '0';
            }
            TreeNode treeNode = new TreeNode(val);
            if(level>0){
                TreeNode parent = list.get(level -1);
                if(parent.left==null){
                    parent.left = treeNode;
                }else{
                    parent.right = treeNode;
                }
            }
            list.add(level, treeNode);//向指定位置插入一个元素
        }
        return list.get(0);
    }
    
    public class TreeNode {
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

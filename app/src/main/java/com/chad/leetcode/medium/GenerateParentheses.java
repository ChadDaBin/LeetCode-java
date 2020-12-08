package com.chad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GenerateParentheses {

    /**
     * 思路：
     * 终止条件为：左右两边的括号都用完。
     * 括号的合法性为：
     * 左右两边的括号总和为2n， 左右各为n
     * 左括号的数量必须小于等于n
     * 右括号的数量必须小于现存的左括号
     * 在每次递归的过程中更新左右括号的状态，同时使用分支验证括号的合法性。
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res,"",0,0,n);
        return res;
    }

    private void generateParenthesis(List<String> res,String tmp,int left,int right,int n){
        if(left == n && right == n){
            res.add(tmp);
        }
        if(left<n) generateParenthesis(res,tmp+"(",left+1,right,n);
        if(right<left) generateParenthesis(res,tmp+")",left,right+1,n);
    }

}

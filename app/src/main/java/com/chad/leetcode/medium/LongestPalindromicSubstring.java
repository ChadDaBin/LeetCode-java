package com.chad.leetcode.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LongestPalindromicSubstring {

    /**
     * 思路：我们定义 dp[i][j] 的意思为字符串区间 [i, j] 是否为回文串，那么我们分三种情况：
     * 当 i == j 时，那么毫无疑问 dp[i][j] = true；
     * 当 i + 1 == j 时，那么 dp[i][j] 的值取决于 s[i] == s[j]；
     * 当 i + 1 < j 时，那么 dp[i][j] 的值取决于 dp[i + 1][j - 1] && s[i] == s[j]。
     * 根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话显而易见，也是 O(n^2)。
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int start = 0,end = 0;
        char[] chars = s.toCharArray();
        for(int i = 0;i<len;i++){
            dp[i][i] = true;
            for(int j = 0;j<i;j++){
                if(j + 1 == i){
                    dp[j][i] = chars[j] == chars[i];
                }else if(j+1<i){
                    dp[j][i] = dp[j+1][i-1]&&chars[j]==chars[i];
                }
                if(dp[j][i]&&i-j>end-start){
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start,end+1);
    }

}

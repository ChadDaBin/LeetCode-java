package com.chad.leetcode.hard;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class RegularExpressionMatching {

    /**
     * 思路：1.当p为空的时候，判断s。如果s为空，则return true,否则返回false
     *      2.当p的第二个字串为*的时候，则先判断*可以等于0的情况或者二者首字母不匹配，此时就递归调用p.substring(2)和s的匹配。
     *      否则，就判断s和p首位字母是否匹配，如果匹配就去递归调用p和s.substring(1)的匹配。
     *      3.当不满足前面2种情况下，就判断第一个字符是否匹配并且递归调用他们去掉首位的子字符串。
     */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if(p.length()>1&&p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    &&isMatch(s.substring(1),p));
        }else{
            return !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        }
    }
}

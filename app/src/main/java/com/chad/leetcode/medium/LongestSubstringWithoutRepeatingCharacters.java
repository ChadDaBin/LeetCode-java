package com.chad.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 思路：滑动窗口,双指针。
     * map (k, v)，其中 key 值为字符，value 值为字符位置;
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0,end = 0;
        while(end<len){
            char t = s.charAt(end);
            if(map.containsKey(t)){
                start = Math.max(start,map.get(t)+1);
            }
            map.put(t,end);
            res = Math.max(res,end-start+1);
            end++;
        }
        return res;
    }
}

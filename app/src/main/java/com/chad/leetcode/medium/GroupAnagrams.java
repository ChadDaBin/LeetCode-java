package com.chad.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GroupAnagrams {

    /**
     * 思路：题意是给你一组字符串，让你把其中同位异构字符串分组，同位异构字符串就是组成字符串的字符都相同，
     * 但是字符放的位置可以不同。既然要分组，那么关键就是如何确定他们是同位异构字符串呢，想到的自然就是对其排序，
     * 排序之后他们就都是同一个字符串了，就可以归为一类了。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return Collections.emptyList();
        List<List<String>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int index = 0;
        for(String str:strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String sortStr = String.valueOf(tmp);
            if(!map.containsKey(sortStr)){
                map.put(sortStr,index++);
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            }else{
                res.get(map.get(sortStr)).add(str);
            }
        }
        return res;
    }
}

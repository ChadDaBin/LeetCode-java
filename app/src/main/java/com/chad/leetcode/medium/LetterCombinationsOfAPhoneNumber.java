package com.chad.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return Collections.emptyList();
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        int len = digits.length();
        for(int i = 0;i<len;i++){
            char tmp = digits.charAt(i);//2,3,4...
            String singleNumOfString = map[tmp-'0'];//"abc","def",...
            int queueSize = queue.size();
            for(int j = 0;j<queueSize;j++) {
                String top = queue.poll();//取出队首元素
                for (int k = 0; k < singleNumOfString.length(); k++) {
                    StringBuilder stringBuilder = new StringBuilder(top);
                    stringBuilder.append(singleNumOfString.charAt(k));
                    queue.offer(stringBuilder.toString());
                }
            }
        }
        return queue;
    }
}

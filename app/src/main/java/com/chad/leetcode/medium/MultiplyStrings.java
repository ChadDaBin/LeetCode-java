package com.chad.leetcode.medium;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int l1 = num1.length(),l2 = num2.length(),l = l1 + l2;
        char[] charsArray1 = num1.toCharArray();
        char[] charsArray2 = num2.toCharArray();
        int[] res = new int[l];
        for(int i = l1 - 1;i>=0;i--){
            int n1 = charsArray1[i] - '0';
            for(int j = l2 - 1;j>=0;j--){
                int n2 = charsArray2[j] - '0';
                int sum = res[i+j+1] + n1*n2;
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<res.length;i++){
            if (i == 0 && res[i] == 0) continue;
            ans.append(res[i]);
        }
        return ans.toString();
    }
}

package com.chad.leetcode.medium;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class PowXN {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? helper(x,N) : 1.0/ helper(x,-N);
    }

    private double helper(double x, long N){
//        if(N==0) return 1.0;
//        else if(N==1) return x;
//        double sub = helper(x,N/2);
//        return N % 2 == 0 ? sub * sub : sub * sub * x;
        double ans = 1.0;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x;
            }
            // 将贡献不断地平方
            x *= x;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}

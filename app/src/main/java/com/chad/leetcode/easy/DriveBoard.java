package com.chad.leetcode.subject.easy;

/**
 *你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例 1
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DriveBoard {

    /**
     * 思路：当 k == 0 时，返回 [] 即可；
     *
     * 当 shorter == longer 时，返回 [k * shorter] 即可；
     *
     * 当 shorter != longer 时，那么其实就是一个首项为 k * shorter，末项为 k * longer，公差为 longer - shorter 的等差数列么；
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{shorter*k};
        }else{
            int[] res =  new int[k+1];
            int start = k*shorter;//首项
            int tolerance = longer - shorter;//公差
            for(int i = 0;i<=k;i++){
                res[i] = start + i*tolerance;
            }
            return res;
        }
    }
}

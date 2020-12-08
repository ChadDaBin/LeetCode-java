package com.chad.leetcode.hard;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] res = new int[len+1][2];
        int i = 0, resIndex = 0;
        //将新区间左边相离的元素添加进来
        while(i<len&&intervals[i][1]<newInterval[0]){
            res[resIndex++] = intervals[i++];
        }
        //将有相交的区间先进行合并，再添加进res里面
        while(i<len&&intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res[resIndex++] = newInterval;
        while(i<len){
            res[resIndex++] = intervals[i++];
        }
        return Arrays.copyOf(res,resIndex);//去除多余的默认值
    }
}

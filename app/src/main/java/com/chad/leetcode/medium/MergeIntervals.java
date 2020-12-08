package com.chad.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==1) return intervals;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);//先对所有区间的开始位置进行排序
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int preIndex = 0;
        res.add(new int[]{start,end});
        for(int i = 1;i<intervals.length;i++){
            int[] tmp = new int[2];
            if(intervals[i][0]<=end){
                end = Math.max(intervals[i][1],end);
                tmp[0] = start;
                tmp[1] = end;
                res.set(preIndex,tmp);
            }else{
                preIndex++;
                start = intervals[i][0];
                end = intervals[i][1];
                tmp[0] = start;
                tmp[1] = end;
                res.add(tmp);
            }
        }
        return res.toArray(new int[0][]);
    }
}

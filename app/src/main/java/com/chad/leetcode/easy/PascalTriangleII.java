package com.chad.leetcode.subject.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
class PascalTriangleII {

    /**
     * 思路：更新过程为：从倒数第二个元素开始往前更新 它等于原来这个位置的数 + 前一个位置的数
     * 也就是 ==>  行[i] = 行[i] + 行[i-1]
     * eg: 1
     *     1 1
     *     1 2 1
     *     1 3 3 1
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<=rowIndex;i++){
            res.add(1);//每一行的最后一列元素为1
            for(int j = i-1;j>=1;j--){ //从倒数第二个元素开始
                res.set(j,res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}

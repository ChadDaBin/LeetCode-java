package com.chad.leetcode.subject.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            List<Integer> sub = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j==0||j==i){
                    sub.add(1);
                }else{
                    List<Integer> upList = res.get(i-1);
                    sub.add(upList.get(j-1)+upList.get(j));
                }
            }
            res.add(sub);
        }
        return res;
    }
}

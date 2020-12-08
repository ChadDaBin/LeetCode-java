package com.chad.leetcode.subject.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // for(int i = 0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return null;
        // 利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 i = 0 时，此时首先要判断
        // nums[0] = 2 是否在 map 中，如果不存在，那么插入键值对 key = 9 - 2 = 7, value = 0，之后当 i = 1时，
        // 此时判断 nums[1] = 7 已存在于 map 中，那么取出该 value = 0 作为第一个返回值，当前 i 作为第 二个返回值，
        // 具体代码如下所示。
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = nums.length;
        for(int i = 0;i<len;i++){
            Integer value = map.get(nums[i]);
            if(value!=null){
                return new int[]{value,i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}

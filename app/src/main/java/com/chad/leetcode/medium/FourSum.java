package com.chad.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if(len>=4){
            List<List<Integer>> ans=new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0;i<len-3;i++){
                //枚举最小的数字
                if(i>0&&nums[i]==nums[i-1]){continue;}//最小数字不可重复
                if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){break;}//只要和大于t那么后边都不用看了
                if(nums[i]+nums[len-3]+nums[len-2]+nums[len-1]<target){continue;}
                //最大的可能和也不足t只能重新枚举最小数
                for(int j=i+1;j<len-2;j++){
                    //下面列举第二小的数
                    if(j>i+1&&nums[j]==nums[j-1]){continue;}//第二小的数字也不能重复
                    if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){break;}//只要和大于t那么后边都不用看了
                    if(nums[i]+nums[j]+nums[len-2]+nums[len-1]<target){continue;}
                    //最大的可能和也不足t只能重新枚举第二小的数
                    int l=j+1;
                    int r=len-1;
                    //l和r分别代表第3,4个数
                    while(l<r){
                        int sum=nums[i]+nums[j]+nums[l]+nums[r];
                        if(sum==target){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                            while(l<r&&nums[l]==nums[l+1]){l++;}//去重第三个数
                            while(l<r&&nums[r]==nums[r-1]){r--;}//去重第四个数
                            l++;
                            r--;
                        }
                        else if(sum>target){r--;}
                        else{l++;}
                    }
                }
            }
            return ans;
        }
        return new ArrayList<>();
    }
}

package com.chad.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ThreeSum {

    /**
     * 思路：双指针+排序
     * 1.先将数组排序，这样就当nums[i]>0得时候提前返回结果。
     * 2.对于重复元素，跳过，避免重复解。
     * 3.令左指针L=i+1,R=n-1,当L<R得时候，循环执行。
     *   当 nums[i]+nums[l]+nums[r]==0,继续执行，判断左界和右界是否和下一位置重复，
     *    去除重复解。并同时将 L,R 移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R] 太大，RR 左移
     * 若和小于 0，说明 nums[L] 太小，LL 右移
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len <= 2) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {  // nums[left] + nums[right] > target
                    r--;
                }
            }
        }
        return ans;
    }
}

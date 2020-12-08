package com.chad.leetcode.medium;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 *
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SearchInRotatedSortedArray {

    /**
     * 思路：我们可以知道，如果nums[mid]>=nums[l],则说明前半部分是递增的，否则就是后半部分是递增的。
     * 那么由这个思路可得出：我们只需要判断target是否落在前半部分还是后半部分，然后判断target是否位于递增
     * 部分的区间范围内，如果在的话就缩短搜索范围，否则就去另外一部分以相同的思路继续搜索即可。
     */
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>=nums[l]){ //说明前半部分是递增的
                if(nums[l]<=target&&target<nums[mid]) r = mid - 1;
                else l = mid + 1;
            }else{ //说明后半部分是递增的
                if(nums[mid]<target&&target<=nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}

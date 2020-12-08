package com.chad.leetcode.medium;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ContainerWithMostWater {

    /**
     * 思路：双指针法。首尾两个指针，容器盛水得体积是 == 两个指针指向的数字中较小值∗指针之间的距离
     * 如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，后者「指针之间的距离」会减小，
     * 那么这个乘积会减小。因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length -1;
        int res = 0;
        while(l<=r){
            int area = Math.min(height[l],height[r])*(r-l);
            res = Math.max(res,area);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}

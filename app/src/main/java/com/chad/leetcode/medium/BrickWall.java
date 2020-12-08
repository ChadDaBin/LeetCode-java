package com.chad.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你的面前有一堵矩形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 *
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 *
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 *
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 *  
 *
 * 示例：
 *
 * 输入: [[1,2,2,1],
 *       [3,1,2],
 *       [1,3,2],
 *       [2,4],
 *       [3,1,2],
 *       [1,3,1,1]]
 *
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BrickWall {

    /**
     * 思路:在这种方法中，我们使用哈希表 map 来保存记录 (sum, count) ，
     * 这里 sum 是当前行累积的砖头宽度， count 是 sum 对应的穿过砖头数目。
     *
     * 我们来看一看过程是如何进行的。我们逐一遍历墙的每一行，对于每一块砖，我们将当前行遇到的所有砖头的宽度加起来得到 sum，
     * 如果这个 sum 在 map中没有出线过，我们创建一个初始 count 值为 1 的相应条目。
     * 如果 sum 已经存在于哈希表中，我们只需要给对应的 count 加一。
     *
     * 这个过程的原理基于以下观察：我们在遍历同一行的时候不会遇到相同的 sum 两次。
     * 所以如果 sum 在遍历过程中遇到相同的值，说明一定存在别的行 sum 也是那些行的衔接处。
     * 所以对应的 count值需要加一。
     *
     * 对于每一行，我们只考虑到倒数第二块砖头的 sum 值，因为最后一块砖头的右边界不是一个衔接处。
     * 最后，我们从哈希表中找到最大的 count 值，用这个值求出垂直竖线穿过的最少砖块数。
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer > map = new HashMap<>();
        for(List<Integer> row: wall){
            int sum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }else {
                    map.put(sum, 1);
                }
            }
        }
        int res = wall.size();
        for(int key: map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }
}

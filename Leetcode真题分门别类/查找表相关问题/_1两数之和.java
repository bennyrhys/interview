package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;

/**
 * @Author bennyrhys
 * @Date 2020-03-23 20:42
 *
 * 思路：
 * 法1：暴力O(n^2)
 * 法2：排序O(nlogn)+指针对撞O(n)
 * 要保证排序后保留原索引信息
 * 法3查找表
 * HashMap，k存值v存索引【问题：数组值重复，后索引覆盖前索引。解决：查找表只放查找值当前的元素】
 * 查找target-a，b是否存在
 *
 * 复杂度:
 * 时间O(N)
 * 空间O(N)
 */
public class _1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查找剩余目标值
            int complement =  target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

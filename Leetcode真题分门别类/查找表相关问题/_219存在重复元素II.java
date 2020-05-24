package Leetcode真题分门别类.查找表相关问题;

import java.util.HashSet;

/**
 * @Author bennyrhys
 * @Date 2020-05-24 16:09
 * 思路：
 * 查找表+滑动窗口k+1大小
 *
 * 复杂度：
 * 时间O（n）
 * 空间O（k）
 */
public class _219存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() == k+1) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}

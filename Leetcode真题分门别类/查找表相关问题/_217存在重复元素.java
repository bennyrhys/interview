package Leetcode真题分门别类.查找表相关问题;

import java.util.HashSet;

/**
 * @Author bennyrhys
 * @Date 2020-05-24 17:05
 * 思路：
 * set不重复元素形成的查找表
 *
 * 复杂度：
 * 时间O（n）
 * 空间O（n）
 */
public class _217存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}

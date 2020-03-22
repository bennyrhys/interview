package Leetcode真题分门别类.查找表相关问题;

import java.util.HashSet;

/**
 * @Author bennyrhys
 * @Date 2020-03-22 21:46
 * 思路：
 * 函数库，利用set去重
 * 空间上去重可以少用一层set
 * 复杂度：
 * 时间O(n)
 * 空间近似O(n)
 */
public class _349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        // 去重
        for (int i : nums1) {
            set.add(i);
        }

        // 取交集
        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }


        Object[] array = resultSet.toArray();
        int length = array.length;

        // 存入返回数组
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int)array[i];
        }

        return result;
    }
}

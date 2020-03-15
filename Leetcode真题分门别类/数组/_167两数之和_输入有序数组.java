package Leetcode真题分门别类.数组;

import java.util.ArrayList;

/**
 * @Author bennyrhys
 * @Date 2020-03-15 22:30
 *
 * 思路：
 * 暴力,未用上有序
 * 注意：题意不要用重复元素,返回数组从1开始
 *
 * 复杂度：
 * 时间O(n)
 * 空间O(1)
 *
 */
public class _167两数之和_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && i!=j) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                    return arr;
                }
            }
        }
        return arr;
    }
}

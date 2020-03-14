package Leetcode真题分门别类.数组;

import java.util.Arrays;

/**
 *
 * @Author bennyrhys
 * @Date 2020-03-14 17:48
 *
 * 思想：
 * 库函数
 *
 * 复杂度
 * 时间：O(n+mlog(n+m))
 * 空间：O(1)
 */
public class _88合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 没利用数组有序特点
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

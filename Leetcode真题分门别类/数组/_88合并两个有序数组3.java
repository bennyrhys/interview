package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-14 19:41
 * 思路：
 * 双指针，利用有序性
 * 从后往前，优化从前往后的m空间浪费
 *
 * 复杂度：
 * 时间O(m+n)
 * 空间O(1)
 */
public class _88合并两个有序数组3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指向尾端的双指针，待填充的尾指针
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        // 计数
        int index;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}

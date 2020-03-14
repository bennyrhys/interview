package Leetcode真题分门别类.数组;

/**
 *
 * @Author bennyrhys
 * @Date 2020-03-14 18:18
 *
 * 思想：
 * 双指针，利用有序特点
 * 从前往后，开辟空间m
 *
 * 复杂度
 * 时间：O(m+n)
 * 空间：O(m)
 */
public class _88合并两个有序数组2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 计数，双指针-分别指向两数组首地址
        int index = 0, p1 = 0, p2 = 0;

        // 备份一份nums1
        int[] new_nums1 = new int[m];
        System.arraycopy(nums1, 0, new_nums1, 0, m);

        // 往nums1中存
        while ((p1 < m) && (p2 < n)) {
            nums1[index++] = (new_nums1[p1] > nums2[p2]) ? nums2[p2++] : new_nums1[p1++];
        }

        // 处理剩余尾部元素
        if (p1 < m) {
            // 剩余的是p2
            System.arraycopy(new_nums1, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n){
            // 剩余的是p1
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }


}

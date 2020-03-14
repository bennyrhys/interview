package Leetcode真题分门别类.数组;

/**
 *
 * @Author bennyrhys
 * @Date 2020-03-14 18:18
 *
 * 思想：
 * 双指针，利用有序特点
 *
 * 复杂度
 * 时间：O(n)
 */
public class _88合并两个有序数组2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int index = 0; // 计数


        for (int i = 0, j = 0; i < m || j < n;) {
                //

                // 比较大小，ij记录当前指向两个数组元素
                if (nums1[i] < nums2[j]) {
                    temp[index++] = nums1[i++];
                }else {
                    temp[index++] = nums2[j++];
                }
        }

        nums1 = temp;
    }


}

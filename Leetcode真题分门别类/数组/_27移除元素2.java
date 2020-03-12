package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:31
 *
 * 要求：
 * 空间复杂度O(1)
 *
 * 思路：
 */
public class _27移除元素2 {
    public int removeElement(int[] nums, int val) {

        int count = 0; // 记录val出现的次数
        int k = 0; // nums中，[0……k]的元素均为非val

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) { // 如果出现val和后面交换位置
                nums[k++] = nums[i];
            }else {
                count++;
            }
        }
        return (nums.length - count);
    }
}

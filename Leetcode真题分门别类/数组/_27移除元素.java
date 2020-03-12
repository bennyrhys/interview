package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:12
 *
 * 要求：
 * 空间复杂度O(1)
 *
 * 思路：双指针针-慢指，k记录不为val的元素。count记录当前不为val的个数。
 */
public class _27移除元素 {
    public int removeElement(int[] nums, int val) {
        int k = 0; // 慢指针，记录不为val的个数
        for (int i = 0; i < nums.length; i++) {
            // 不为val的，重新依次存入
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}

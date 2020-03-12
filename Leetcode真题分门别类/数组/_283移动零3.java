package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 22:51
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 思想：【0通过交换位置保留】
 */
public class _283移动零3 {

    public void moveZeroes(int[] nums) {
        int k = 0; // nums中，[0……k)的元素均为非0元素

        // 遍历到第i个元素后，保证[0……i]中所有非0元素
        // 都按照顺序排列在[0……k中)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                // 交换
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;

                k++;
            }
        }
    }
}

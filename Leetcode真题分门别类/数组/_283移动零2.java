package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 22:38
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 思想：【优化空间复杂度】非零元素向前移动，添加k指向非零空间[0,k)
 */
public class _283移动零2 {

    public void moveZeroes(int[] nums) {
        int k = 0; // nums中，[0……k)的元素均为非0元素

        // 遍历到第i个元素后，保证[0……i]中所有非0元素
        // 都按照顺序排列在[0……k中)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // 将nums剩余位置放置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

}

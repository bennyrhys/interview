package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:59
 *
 * 要求：
 * O(1) 额外空间
 *
 * 思想：
 * 利用有序性，双指针覆盖元素【方法二：覆盖多余的重复项】
 *
 *
 * 时间复杂度：O(n)
 */
public class _80删除排序数组中的重复项II2 {


    public int removeDuplicates(int[] nums) {
        // 起始第二个元素， 需要覆盖元素的位置（重点是对此位置的各种情况移动），重复个数，数组长
        int i = 1, j = 1, count = 1, len = nums.length;

        while (i < len) {
            // 当遇到重复
            if (nums[i] == nums[i-1]) {
                count++;
            }else {
                // 遇到不重复的 【将i给j】
                count = 1;
            }
            // 凡不超过2，【i++,j++】
            if (count <= 2) {
                nums[j++] = nums[i];
            }
            i++;
        }
        System.out.println(j);

        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        new _80删除排序数组中的重复项II2().removeDuplicates(arr);
    }
}

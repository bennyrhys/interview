package Leetcode真题分门别类.数组;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @Author bennyrhys
 * @Date 2020-03-14 20:40
 * 思路：
 * 函数库，排序找最大
 *
 * 复杂度：
 * 时间：O(nlogn)
 * 空间O(1)
 */
public class _215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num);
        }
//        System.out.println(nums[-k]);

        // 标记k的位置
        int count = 0;
        for (int i = nums.length - 1; i < nums.length; i--) {
            count++;
            if (count == k) {
                return nums[i];
            }

        }

        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int a = new _215数组中的第K个最大元素().findKthLargest(arr,4);
        System.out.println(a);
    }

}

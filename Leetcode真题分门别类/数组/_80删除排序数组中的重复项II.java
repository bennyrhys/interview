package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:59
 *
 * 要求：
 * O(1) 额外空间
 *
 */
public class _80删除排序数组中的重复项II {
    public int[] remElement(int[] arr, int index) {



        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    public int removeDuplicates(int[] nums) {

        int i = 1, count = 1, length = nums.length;

        while (i < length) {


            if (nums[i] == nums[i - 1]) {

                count++;


                if (count > 2) {

                    this.remElement(nums, i);

                    i--;

                    length--;
                }
            } else {

                count = 1;
            }

            i++;
        }

        return length;
    }
}

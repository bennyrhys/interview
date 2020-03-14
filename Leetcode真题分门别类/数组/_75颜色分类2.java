package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-14 10:46
 *
 * 思路：
 * 三路快排，一次遍历
 *
 * 复杂度：
 * 时间O(n)
 * 空间O(i)
 */
public class _75颜色分类2 {
    public void sortColors(int[] nums) {
        int zero = -1; // [0……zero]
        int two = nums.length; // [two……n-1]

        for (int i = 0; i < two; ) { // 注意此处没有i++，内部循环有不需要++的情况
            if (nums[i] == 2) {
                two--;

                // 交换
                int temp = 0;
                temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }else if (nums[i] == 1) {
                i++;
            }else { // nums[i] == 0
                zero++;

                // 交换
                int temp = 0;
                temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;

                i++;
            }
        }
    }
}

package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 16:34
 *
 * 注意：
 * 连续子数组
 *
 * 思路：
 * 暴力
 *
 * 复杂度：
 * 时间O(N^2)【优化遍历求和的一个^复杂度】
 * 空间O(1)
 *
 */
public class _209长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        // 区间长度
        int min = Integer.MAX_VALUE;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int start = i;
            int sum = 0; // 千万注意统计总和的位置很重要

            while (start < length) {
                sum += nums[start++];
                //当前和大于等于 s 的时候结束
                if (sum >= s) {
                    min = Math.min(min, start - i); // 这里要想明白，要想记为一个数必须先star++
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int s = 7;
        int[]nums = {2,3,1,2,4,3};
        int i = new _209长度最小的子数组().minSubArrayLen(s, nums);
        System.out.println(i);
    }
}

package Leetcode真题分门别类.数组;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 19:48
 *
 * 思路：
 * 双指针-滑动窗口
 * 避免暴力，大量数据重叠
 *
 * 复杂度：
 * 时间O(n)
 * 空间O(1)
 */
public class _209长度最小的子数组2 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1; // nums[l……r]为滑动窗口，r为-1，保证初始化为空
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (l < nums.length) {
            // 移动窗口
            if (sum < s && r+1 < nums.length) { // 防止数组越界
                sum += nums[++r]; // 不足，右侧窗口先右移，再赋值
            }else {
                sum -= nums[l++]; // 过多，左侧先减掉，再右移
            }

            // 判断是否满足和
            if (sum >= s) {
                res = Math.min(res, r-l+1); // r-l+1，+1是因为这是闭区间，要计数必须加1
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

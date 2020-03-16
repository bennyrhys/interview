package Leetcode真题分门别类.数组;

import java.util.logging.Level;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 15:19
 *
 * 思路：
 * 双指针对撞，每次向内移动竖线短的一端
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 *
 */
public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        // 初始化双指针
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            // 比较最大面积
            res = Math.max(res ,Math.min(height[l], height[r]) * (r - l));

            // 左边底
            if (height[l] < height[r]) {
                 // 底*高
                l++;
            }
            // 右边底
            else {
                r--;
            }
        }
        return res;
    }
}

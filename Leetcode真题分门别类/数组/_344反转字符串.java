package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 13:13
 * 思路：
 * 双指针碰撞
 *
 * 要求：
 * 空间O(1)
 *
 * 复杂度：
 * 时间O(N)
 */
public class _344反转字符串 {
    public void reverseString(char[] s) {
        int left = 0 , right = s.length - 1, mid = (left + right)/ 2;

        // 前后两两交换
        while (left <= mid && left < right) {
            char temp;
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}

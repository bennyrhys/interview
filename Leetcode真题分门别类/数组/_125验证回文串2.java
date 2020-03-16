package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 12:48
 * 思想：
 * 双指针对撞
 *
 * 复杂度：
 * 时间O(n)
 * 空间O(1)
 */
public class _125验证回文串2 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }

        return true;
    }
}

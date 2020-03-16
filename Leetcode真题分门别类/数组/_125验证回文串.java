package Leetcode真题分门别类.数组;

import javax.sound.midi.Soundbank;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 10:06
 *
 * 思路：
 * 库函数，便全部小写
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 */
public class _125验证回文串 {
    public boolean isPalindrome(String s) {
        // 初始化左右指针
        char[] carr = s.toLowerCase().toCharArray();
        // 存处理后数据
        StringBuilder sb = new StringBuilder();

        for (char c : carr) {
            // 判字母，数字
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        boolean status = sb.toString().equals(sb.reverse().toString());
        return status;
    }

    public static void main(String[] args) {
        String s = "A man, 68787a plan, a canal: 》>Panama";
        boolean isReWord = new _125验证回文串().isPalindrome(s);
        System.out.println(isReWord);
    }
}

package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 20:58
 * 思路：
 * 滑动窗口，
 * 通过freq[256]统计ASCII出现的频率
 *
 * 注意：
 * 大小写敏感
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 *
 */
public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256]; // 记录ASCII对应的出现频率
        int l = 0, r = -1; // 滑动窗口s[l...r]
        int res = 0;
        char[] sc = s.toCharArray();

        while (l < sc.length) {
            if ( r + 1 < sc.length && freq[sc[r+1]] == 0) { // 小心r+1数组越界
                freq[sc[++r]]++; // 右侧右移，将移后频率++
            } else {
                freq[sc[l++]] --; // 先减少左侧频率，再将左侧右移
            }
            res = Math.max(res, r-l+1); // 因为闭区间，滑动窗口计数+1
        }
        return res;
    }
}

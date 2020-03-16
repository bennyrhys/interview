package Leetcode真题分门别类.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 21:40
 * 思路：
 * 滑动窗口
 *
 * 注意：
 * 只包含小写英文字母
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 */
public class _438找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //子串长，用total检测窗口中是否已经涵盖了p中的字符

        for(char ch : p.toCharArray()){ //统计子串频率
            needs[ch - 'a'] ++;
        }

        while(right < s.length()){
            char chr = s.charAt(right);
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }

}

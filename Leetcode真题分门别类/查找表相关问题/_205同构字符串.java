package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;

/**
 * @Author bennyrhys
 * @Date 2020-03-23 17:22
 * 注意：
 * 空串、字符集
 *
 * 思路：
 * map映射
 *
 * 复杂度
 * 时间O(N)
 * 空间O(n)
 */
public class _205同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        // 空串
        if (s.length() == 0 && t.length() == 0) return true;

        // 映射
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) { // 没有映射关系时执行
                if (map.containsValue(t.charAt(i))) return false; // 没有映射的情况下ti已被使用，则不匹配返回false
                map.put(s.charAt(i), t.charAt(i)); // 构建映射
            }else {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) return false;
            }
        }
        return true;
    }
}

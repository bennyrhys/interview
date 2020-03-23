package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;

/**
 * @Author bennyrhys
 * @Date 2020-03-23 12:32
 * 注意：
 * 空串、字符集(只包含小写字母)
 *
 * 思路：
 * map记频次
 *
 * 复杂度：
 * 时间近O(n)
 * 空间近O(3N)
 *
 */
public class _242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {

        // 排特情
        if (s.length() == 0 || t.length() == 0) return true;

        // map记频
        HashMap<Object, Integer> countMap = new HashMap<>();

        char[] charss = s.toCharArray();
        char[] charst = t.toCharArray();

        // 统计s的数据
        for (char c : charss) {
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        System.out.println(countMap);

        // 验证t是否与s内容匹配
        for (char c : charst) {
            countMap.put(c, countMap.getOrDefault(c, 0)-1);
        }

        // 检验s,t是否一致
        int count = 0; // 记是否都归零
        for (Object o : countMap.values()) {
            if (!o.equals(0)) count++;
        }

        // forEach lambda 无法引入外部变量
//        countMap.forEach((k,v)->{
//            System.out.println("k"+k+ "v"+v);
//        });
        System.out.println(countMap);

        // 状态
        if (count == 0) return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = new _242有效的字母异位词().isAnagram(s, t);
        System.out.println(anagram);
    }
}

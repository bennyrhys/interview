package Leetcode真题分门别类.查找表相关问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author bennyrhys
 * @Date 2020-05-14 08:55
 * 通过排序后元素一样，可以过滤
 *
 */
public class _49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        HashMap<String, List> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!hashMap.containsKey(key)) hashMap.put(key,new ArrayList());
            hashMap.get(key).add(str);
        }
        return new ArrayList(hashMap.values());
    }
}

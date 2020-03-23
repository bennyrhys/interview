package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bennyrhys
 * @Date 2020-03-23 14:54
 * 注意：
 * 空串，字符集
 *
 * 思路：
 * 这个解法主要是找字符和字符串的映射关系：
 *
 * 先以split分隔str得到字符串数组s
 * 如果pattern中的字符个数和数组s.length不相等，说明无法一一对应，返回false
 * 当pattern.charAt(i)还没有对应的字符串时，判断s[i]是否已经与其他字符构建了映射关系，是则返回false,否则与s[i]构建映射
 * 当pattern.charAt(i)有对应的字符串时，判断是否与s[i]相等，不相等则返回false
 * 遍历完pattern，说明一一对应，返回true
 *
 * 复杂度
 * 时间近似O(N)
 * 空间O(N)
 *
 */
public class _290单词规律 {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" "); //以空格分隔str
        if(s.length != pattern.length()) return false; //如果没有全部成对的映射则返回false
        Map<Character, String> map = new HashMap<>(); //存放映射
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){ //1. 没有映射时执行
                if(map.containsValue(s[i])) return false; //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                map.put(pattern.charAt(i), s[i]); //3. 构建映射
            }else{
                if(!map.get(pattern.charAt(i)).equals(s[i])) return false; //当前字符串与映射不匹配,返回false
            }
        }
        return true;
    }
}

package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 14:01
 *
 * 思路：
 * 对撞指针
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 */
public class _345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        // 初始化双指针指向
        int left = 0, right = s.length() - 1;
        // 转成char数组
        char[] schar = s.toCharArray();

        while (left < right) {
            // 不是元音
            while (left < schar.length && judge(schar[left])) left++;
            while (right >= 0 && judge(schar[right])) right--;

            if (left >= right) break;

            // 交换两都是元音
            char temp;
            temp = schar[left];
            schar[left++] = schar[right];
            schar[right--] = temp;

        }
        return String.valueOf(schar);
    }

    /**
     * 判空
     * @param c
     * @return
     */
    public boolean judge(char c){
        if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='A' && c!='E' && c!='I' && c!='O' && c!='U'){
            return true;
        }else{return false;}
    }
}

package Leetcode真题分门别类.查找表相关问题;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author bennyrhys
 * @Date 2020-03-23 13:53
 * 思想：
 * set计数防止死循环
 * 判断几位数，位数平方和，循环
 *
 * 复杂度：
 * 时间近O(N)
 * 空间O(N)
 *
 */
public class _202快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = change(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        int num;
        while(n != 0){
            num = n%10;
            n /= 10;
            sum += num*num;
        }
        return sum;
    }
}

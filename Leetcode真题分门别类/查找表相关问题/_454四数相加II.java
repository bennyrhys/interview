package Leetcode真题分门别类.查找表相关问题;

import java.util.HashMap;

/**
 * @Author bennyrhys
 * @Date 2020-03-27 23:18
 * 思路：
 * 查找表
 * 四数组暴力的话时间复杂度O(n^4)绝对不行
 * 前两组数据比较，后两组生成查找表。变时间复杂度为O(n^2)
 * map存储后两组，组合结果。及相同结果出现次数
 *
 * 复杂度：
 * 时间O(n^2)
 * 空间O(n^2)
 */
public class _454四数相加II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> recard = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                recard.put(C[i]+D[j], recard.getOrDefault(C[i]+D[j], 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (recard.containsKey(0 - A[i] - B[j])) {
                    res += recard.get(0 - A[i] - B[j]);
                }
            }
        }
        return res;
    }
}

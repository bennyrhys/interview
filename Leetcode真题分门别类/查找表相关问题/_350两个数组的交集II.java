package Leetcode真题分门别类.查找表相关问题;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author bennyrhys
 * @Date 2020-03-22 22:27
 * 注意：
 * 计重复
 *
 * 思路：
 * map解决计重
 *
 * 复杂度：
 * 时间近似O(N)
 * 空间近似O(N)
 */
public class _350两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 计nums1中对应数字次数
        for (int i : nums1) {
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }

        int k = 0; // 计数
        for (int i : nums2) {
            if (hashMap.containsKey(i) && hashMap.getOrDefault(i, 0) > 0) {
                nums1[k++] = i;
                hashMap.put(i, hashMap.getOrDefault(i, 0)-1);
            }
        }
        return Arrays.copyOfRange(nums1,0, k);
    }
}

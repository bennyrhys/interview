package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-15 23:11
 *
 * 思路：
 * 利用有序性，二分搜索
 * 由于是有序数组，从左至右遍历，二分查找另一个值，如果找到就返回，
 * 没有找到就更新right，即遍历的范围，因为right为当前值相加后不超过target的位置，
 * 当前元素的后继值必然大于等于当前值，right后的值相加肯定大于target。
 *
 * 复杂度
 * 时间O(nlogn)
 * 空间O(1)
 *
 */
public class _167两数之和_输入有序数组2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left;
        int right = numbers.length - 1; // 记录二分查找第二个值，数组下标的变化，影响范围

        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i]; // 要查找的第二个值，缩小范围

            left = i + 1 ; // 查找除已选中的第一个值的，第一个值
            // 能找到另一个值就返回，找不到就更新right
            while (left <= right) {
                int mid = (left + right) / 2;

                // 找到并返回
                if (numbers[mid] == temp) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
                // 二分
                if (numbers[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}

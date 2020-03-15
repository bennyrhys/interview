package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-16 00:09
 *
 * 思想：
 * 对撞指针，利用有序性
 *
 * 复杂度：
 * 时间O(n)
 * 空间O(1)
 */
public class _167两数之和_输入有序数组3 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1; // 初始化 左右指针位置
        int[] res = new int[2]; // 存放返回的元素

        while (left < right) { // 返回的元素不能重复
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if (numbers[left] + numbers[right] < target) { // 元素总和小于目标，左节点右移
                left++;
            }else { // 和大于目标，右节点左移
                right--;
            }
        }
        throw new IllegalArgumentException("The input has no solution");
    }
}

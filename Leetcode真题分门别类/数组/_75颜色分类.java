package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-14 09:46
 *
 * 思路：分类计数
 *
 * 要求：
 * 不能使用代码库的排序
 *
 * 复杂度：
 * 时间：O(n)
 * 空间：O(1)
 */
public class _75颜色分类 {
    public void sortColors(int[] nums) {
        // 开辟记录012，出现频次
        int[] color = new int[3];

        // 频次记录在数组color
        for (int num : nums) {
                color[num]++;
        }

        // 重排数组
        int index = 0;
        for (int i = 0; i < color[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < color[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < color[2]; i++) {
            nums[index++] = 2;
        }
    }
}

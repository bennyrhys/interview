package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:59
 *
 * 要求：
 * O(1) 额外空间
 *
 * 思想：
 * 利用有序性，移除重复2次以上的元素
 *
 */
public class _80删除排序数组中的重复项II {


    public int removeDuplicates(int[] nums) {
        // 起始比较1 ， 重复元素计数， 当前数组长度
        int i = 1, count = 1, len = nums.length;

        while (i < len) {
            // 处理重复元素
            if (nums[i-1] == nums[i]) {
                count++;
                if (count > 2) {
                    // 移除重复两次的元素
                    removeElement(nums, i);
                    i--;
                    len--;
                }
            }else {
                count = 1;
            }
            i++;
        }
        System.out.println(len);
        return len;
    }

    // 根据节点,删除对应元素
    private int[] removeElement(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            nums[j - 1] = nums[j];
        }

        for (int num : nums) {
            System.out.print(num);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        new _80删除排序数组中的重复项II().removeDuplicates(arr);
    }
}

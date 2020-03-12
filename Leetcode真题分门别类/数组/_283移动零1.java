package Leetcode真题分门别类.数组;

import java.util.ArrayList;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 21:32
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 思路：先将非零元素，记录到另一个空数组，再将其付给原数组其余为零
 */
public class _283移动零1 {
     static class Solution {
        public void moveZeroes(int[] nums) {

            ArrayList<Integer> temp = new ArrayList<>();

            // 非零赋值另一数组
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    temp.add(nums[i]);
                }
            }

            // 还给原数组
            for (int i = 0; i < temp.size(); i++) {
                nums[i] = temp.get(i);
            }

            // 补零
            for (int i = temp.size(); i < nums.length; i++) {
                nums[i] = 0;
            }
            
            // 验证
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};

        Solution solution = new _283移动零1.Solution();
        solution.moveZeroes(arr);
        

    }
}

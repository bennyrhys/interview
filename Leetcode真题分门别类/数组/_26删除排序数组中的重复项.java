package Leetcode真题分门别类.数组;

/**
 * @Author bennyrhys
 * @Date 2020-03-12 23:41
 *
 * 要求:
 * 空间复杂度：O(1)
 * 算法：
 * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
 *
 * 当我们遇到 nums[j] \neq nums[i]nums[j]
 * 
 * ​
 *  =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
 *
 */
public class _26删除排序数组中的重复项 {
    // 返回长度
    public int removeDuplicates(int[] nums) {
        // 特殊-长度为0
        if (nums.length == 0) return 0;

        // 慢指针
        int k = 0;

        // 双指针
        for (int i = 1; i < nums.length; i++) { // 从数组第二项比较
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }
}

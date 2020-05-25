package Leetcode真题分门别类.查找表相关问题;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author bennyrhys
 * @Date 2020-05-25 10:19
 * 思路：
 * 滑动窗口+查找表+二叉树查找set
 *
 * 在 set 上查找大于等于 x 的最小的数，如果 s − x ≤ t s−x≤t则返回 true
 * 在 set 上查找小于等于 x 的最大的数，如果 x − g ≤ t x−g≤t则返回 true
 *
 *  假设这棵树上节点总数为  n ，一个平衡树能把高度维持在  h = log ⁡ n h=logn
 *
 *  我们把大于等于  x  的最小的数  s 当做  x 在 BST 中的后继节点。
 *  同样的，我们能把小于等于  x 最大的数  g 当做  x 在 BST 中的前继节点。 s 和  g 这两个数是距离  x 最近的数。
 *  因此只需要检查它们和  x 的距离就能知道条件二是否满足了
 *
 * 复杂度：
 * 时间O(nlogn)
 * 空间O(n)
 */
public class _220存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() == k+1) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}

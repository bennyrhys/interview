package Leetcode真题分门别类.数组;

import java.util.Random;

/**
 * @Author bennyrhys
 * @Date 2020-03-15 00:17
 *
 * 思想：
 * 快速选择算法
 * 通过快排+利用n-k位置快速锁定的特性，只递归划分的一边
 * 如果是快速排序算法，会在这里递归地对两部分进行快速排序，时间复杂度为O(NlogN)。
 * 而在这里，由于知道要找的第 N - k 小的元素在哪部分中，我们不需要对两部分都做处理，这样就将平均时间复杂度下降到O(N)
 * 划分算法将枢轴放在数组中的合适位置 pos。将小于枢轴的元素移到左边，大于等于枢轴的元素移到右边。
 * 比较 pos 和 N - k 以决定在哪边继续递归处理。
 *
 * 这种方法应该叫快速选择（Quick Select），跟快排的思想是非常接近的：
 * 选取一个基准元素pivot，将数组切分（partition）为两个子数组，
 * 比pivot大的扔左子数组，比pivot小的扔右子数组，然后递推地切分子数组。
 * Quick Select不同于Quick Sort的是其没有对每个子数组做切分，而是对目标子数组做切分。
 *
 * Quick Select的目标是找出第k大元素，所以:
 * 若切分后的左子数组的长度 > k，则第k大元素必出现在左子数组中；
 * 若切分后的左子数组的长度 = k - 1，则第k大元素为pivot；
 * 若上述两个条件均不满足，则第k大元素必出现在右子数组中。
 *
 * 官方会快16ms，this.做空间优化
 *
 */
public class _215数组中的第K个最大元素3 {
    // Quick Select
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, k, 0, nums.length - 1);
        }

        // 快速选择
        public int quickSelect(int[] arr, int k, int left, int right) {
            if (left == right) return arr[right];
            int index = partition(arr, left, right);
            if (index - left + 1 > k) {
                return quickSelect(arr, k, left, index - 1);
            } else if (index - left + 1 == k) {
                return arr[index];
            } else {
                return quickSelect(arr, k - index + left - 1, index + 1, right);
            }
        }

        // 根据大小，切分数组左右两边
        private int partition(int arr[], int left, int right) {
            int i = left, j = right + 1, pivot = arr[left];
            while (true) {
                while (i < right && arr[++i] > pivot) {
                    if (i == right) break;
                }
                while (j > left && arr[--j] < pivot) {
                    if (j == left) break;
                }
                if (i >= j) break;
                swap(arr, i, j);
            }
            swap(arr, left, j);
            return j;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}

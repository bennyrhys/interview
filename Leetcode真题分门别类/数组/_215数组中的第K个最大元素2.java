package Leetcode真题分门别类.数组;

import java.util.PriorityQueue;

/**
 * @Author bennyrhys
 * @Date 2020-03-14 21:44
 * 思路：
 * 通过大根堆，保留k个，取堆顶
 *
 * 复杂度：
 * 时间O(nlogk)
 * 空间O(k)，用于存储堆元素。
 */
public class _215数组中的第K个最大元素2 {
    public int findKthLargest(int[] nums, int k) {
        /**
         * 按照文档中的描述，PriorityQueue是由堆实现的。
         * 由于需要排序，所以PriorityQueue的构造函数可以接收一个Comparator接口的实例，以此来作为比较两个对象大小的依据。
         *
         * 顺带介绍一下Comparator接口，该接口是用来判断两个数之间大小关系的接口，实现该接口需要重写该接口中的一个
         * int compare(T a, T b) 方法
         *
         * 该方法返回一个int值
         * 文档中对该方法对返回描述为
         * a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         * 即返回结果为负数，零，正数，对应a小于，等于，大于b。
         */
       // 创建堆
        PriorityQueue<Integer> heap =  new PriorityQueue<>((n1, n2) -> n1 - n2);

        // 保持k个元素在heap里面
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}

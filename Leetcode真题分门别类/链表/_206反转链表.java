package Leetcode真题分门别类.链表;

/**
 * @Author bennyrhys
 * @Date 2020-05-29 11:42
 *
 * 思路：
 * 链表翻转，直接改变指针指向
 * 保存状态需要创建三个指针（pre前 cur当前 next下一个）
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 *
 * 注意while处正好判断cur是否为空的情况，返回头节点为末尾null的前一个节点cur
 *
 */


import 玩转数据结构.链表看递归.移除链表元素.ListNode;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

public class _206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

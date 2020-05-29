package Leetcode真题分门别类.链表;

/**
 * @Author bennyrhys
 * @Date 2020-05-29 15:39
 * 思想：
 * 链表翻转，直接改变指针指向 反转n-m次
 * head表示需要反转的头节点，pre表示需要反转头节点的前驱节点
 * 保存状态需要创建三个指针（pre前 cur当前 next下一个）
 * 将head的next节点移动到需要反转链表部分的首部
 * 第一次反转：1(head) 2(next) 3 4 5 反转为 2 1 3 4 5
 * 第二次反转：2 1(head) 3(next) 4 5 反转为 3 2 1 4 5
 * 第三次发转：3 2 1(head) 4(next) 5 反转为 4 3 2 1 5
 * 第四次反转：4 3 2 1(head) 5(next) 反转为 5 4 3 2 1
 *
 * 复杂度：
 * 时间O(N)
 * 空间O(1)
 *
 * 注意：
 * n，m范围
 */
public class _92反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (m > 1) {
            prev = prev.next;
            m--;
            n--;
        }
        head = prev.next;
        while (n > 1) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = prev.next;
            prev.next = next;
            n--;
        }
        return dummy.next;
    }
}

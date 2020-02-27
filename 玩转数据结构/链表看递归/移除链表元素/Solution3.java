package 玩转数据结构.链表看递归.移除链表元素;

/**
 * 法3：递归移除
 * @Author bennyrhys
 * @Date 2020-02-27 21:43
 */
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        // 判空
        if (head == null)
            return null;

        // 繁琐
       /*
       // 递归下一个组合
        ListNode res = removeElements(head.next, val);

        // 两种情况处理
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
        */

       // 简化
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }
}
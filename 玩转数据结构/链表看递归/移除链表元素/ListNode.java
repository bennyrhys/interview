package 玩转数据结构.链表看递归.移除链表元素;

/**
 * @Author bennyrhys
 * @Date 2020-02-27 21:45
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 构造函数-转数组
    // 转化数组变成链表，通过ListNode实现
    public ListNode(int[] arr){

        // 判空-空数组
        if (arr == null && arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        // 头节点赋值
        this.val = arr[0];
        // 当前链表头
        ListNode cur = this;

        // 循环赋值
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
    }

    // 便于打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        res.append("ListNode:");
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

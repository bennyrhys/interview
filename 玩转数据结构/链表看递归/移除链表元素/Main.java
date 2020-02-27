package 玩转数据结构.链表看递归.移除链表元素;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @Author bennyrhys
 * @Date 2020-02-27 21:43
 */
public class Main {
    // 构建本地测试用例，提供可以本地调试的环境，创建ListNode中构造函数构建链表

    /**
     * ListNode:1->1->2->2->3->6->4->6->NULL
     * res1:ListNode:1->1->2->2->3->4->NULL
     * res2:ListNode:1->1->2->2->3->4->NULL
     * res3:ListNode:1->1->2->2->3->4->NULL
     * @param args
     */
    public static void main(String[] args) {

        // 转化数组变成链表，通过ListNode实现
        int[] arr = {1, 2, 2, 3, 6, 4, 6};

        // 转化成链表并检验
        ListNode head = new ListNode(arr);
        System.out.println(head);

        // 测试1 特殊处理头的-移除元素
        ListNode res1 = (new Solution()).removeElements(head, 6);

        // 测试2 虚拟头节点-移除元素
        ListNode res2 = (new Solution2()).removeElements(head, 6);

        // 测试3 递归节点-移除元素
        ListNode res3 = (new Solution3()).removeElements(head, 6);

        System.out.println("res1:"+res1+"\n"+"res2:"+res2+"\n"+"res3:"+res3);
    }
}

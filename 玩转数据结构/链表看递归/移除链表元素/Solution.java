package 玩转数据结构.链表看递归.移除链表元素;

/**
 * 法2：特殊处理头节点
 * @Author bennyrhys
 * @Date 2020-02-27 21:43
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /**
         * 思考：通过删除之前的节点删除指定节点。
         *
         * 头节点没有之前的节点
         * 两种处理：
         * 1、特殊处理头
         * 2、虚拟头节点
         */
        //虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

/*        // 1、特殊处理头,删除开始部分的全部节点
        while (head != null && head.val == val) {
//            优化
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;

//            简化
            head = head.next;
        }

        // 所有的节点都为空
        if (head == null) {
            return null;
        }*/

        // 删除链表中间，设置通过前一个节点
        ListNode prev = dummyHead; // 此时head肯定不为删除节点，后面的可以是删除节点

        // 如果没有到结尾
        while (prev.next != null) {
            // 如果后一个节点匹配
            if (prev.next.val == val) {
//                优化
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;

//                简化
                prev.next = prev.next.next;
            } else
                prev = prev.next;
        }

        return dummyHead.next;
    }
}
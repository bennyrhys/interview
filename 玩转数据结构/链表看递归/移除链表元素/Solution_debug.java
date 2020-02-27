package 玩转数据结构.链表看递归.移除链表元素;
import 玩转数据结构.链表看递归.移除链表元素.ListNode;

/**
 * 链表-递归debug
 *
 * ListNode:1->1->2->6->3->4->5->6->NULL
 * Call: remove 6 in ListNode:1->1->2->6->3->4->5->6->NULL
 * --Call: remove 6 in ListNode:1->2->6->3->4->5->6->NULL
 * ----Call: remove 6 in ListNode:2->6->3->4->5->6->NULL
 * ------Call: remove 6 in ListNode:6->3->4->5->6->NULL
 * --------Call: remove 6 in ListNode:3->4->5->6->NULL
 * ----------Call: remove 6 in ListNode:4->5->6->NULL
 * ------------Call: remove 6 in ListNode:5->6->NULL
 * --------------Call: remove 6 in ListNode:6->NULL
 * ----------------Call: remove 6 in null
 * ----------------Return: null
 * --------------After remove 6: null
 * --------------Return: null
 * ------------After remove 6: null
 * ------------Return: ListNode:5->NULL
 * ----------After remove 6: ListNode:5->NULL
 * ----------Return: ListNode:4->5->NULL
 * --------After remove 6: ListNode:4->5->NULL
 * --------Return: ListNode:3->4->5->NULL
 * ------After remove 6: ListNode:3->4->5->NULL
 * ------Return: ListNode:3->4->5->NULL
 * ----After remove 6: ListNode:3->4->5->NULL
 * ----Return: ListNode:2->3->4->5->NULL
 * --After remove 6: ListNode:2->3->4->5->NULL
 * --Return: ListNode:1->2->3->4->5->NULL
 * After remove 6: ListNode:1->2->3->4->5->NULL
 * Return: ListNode:1->1->2->3->4->5->NULL
 * ListNode:1->1->2->3->4->5->NULL
 */
public class Solution_debug{

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution_debug()).removeElements(head, 6, 0);
        System.out.println(res);
    }

}
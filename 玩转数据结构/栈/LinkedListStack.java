package 玩转数据结构.栈;

/**
 * 链表-栈
 * 辅助文件是LinkedList2，虚拟头节点的链表
 *
 * 测试比较
 * @Author bennyrhys
 * @Date 2020-02-26 23:00
 */
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList2<E> list;

    public LinkedListStack() {
        list = new LinkedList2<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:top");
        res.append(list);
        return res.toString();

    }

    /**
     * Stack:top0->NULL
     * Stack:top1->0->NULL
     * Stack:top2->1->0->NULL
     * Stack:top3->2->1->0->NULL
     * Stack:top4->3->2->1->0->NULL
     * Stack:top5->4->3->2->1->0->NULL
     * Stack:top4->3->2->1->0->NULL
     * @param args
     */
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}

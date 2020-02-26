package 玩转数据结构.链表;

/**
 * 链表
 * @Author bennyrhys
 * @Date 2020-02-26 13:48
 */
public class LinkedList<E>  {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    // 记录链表中有多少元素
    private int size;

    // 初始化构造函数
    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 链表头添加元素
    public void addFirst(E e) {
//        Node node = new Node();
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    // 链表中添加元素
    // 在链表的index(0-based)位置添加新的元素e
    // 链表中不是一个常用操作，练习用
    public void add(int index, E e) {
        // 越界
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.index < 0 || index > size ! ");

        // 首部特殊处理【下一步介绍如何不做特殊处理-为表头设置虚拟头结点】
        if (index == 0)
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
//                Node node = new Node(e);
//                node.next = prev.next;
//                prev.next = node;

                prev.next = new Node(e, prev.next);
                size++;
            }
        }
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }



}

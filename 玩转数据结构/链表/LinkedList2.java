package 玩转数据结构.链表;

/**
 * 链表-设立指向表头虚拟头节点【解决-插入元素时,表头单独特殊处理】
 * @Author bennyrhys
 * @Date 2020-02-26 20:48
 */
public class LinkedList2<E>  {
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

    private Node dummyHead;
    // 记录链表中有多少元素
    private int size;

    // 初始化构造函数
    public LinkedList2() {
        dummyHead = new Node(); // 初始化时，创建唯一虚拟头节点
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



    // 链表中添加元素
    // 在链表的index(0-based)位置添加新的元素e
    // 链表中不是一个常用操作，练习用
    public void add(int index, E e) {
        // 越界
        if (index < 0 || index > size)
            throw  new IllegalArgumentException("Add failed.index < 0 || index > size ! ");

        // 首部不用特殊处理【下一步介绍如何不做特殊处理-为表头设置虚拟头结点】

            Node prev = dummyHead; // 从0的前一个元素开始遍历，直到index之前的一个节点
            for (int i = 0; i < index; i++)
                prev = prev.next;
//                Node node = new Node(e);
//                node.next = prev.next;
//                prev.next = node;

            prev.next = new Node(e, prev.next);
            size++;

    }

    // 链表头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表的index(0-based)位置的元素
    // 链表中不是一个常用操作，练习用
    public E get(int index) {
        // 越界
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Illegal index ! ");

        // 从第一个真实元素开始【区别添加时的前一个元素】
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的index(0-based)位置的元素e
    // 链表中不是一个常用操作，练习用
    public void set(int index, E e) {
        // 越界
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Illegal index ! ");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素，返回删除的元素
    // 在链表中不是一个常用操作，练习用
    public E remove(int index) {
        // 越界
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Illegal index ! ");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    // 从链表，删除第一个元素，返回元素e
    public E removeFirst() {
        return remove(0);
    }

    // 从链表，删除最后一个元素，返回e
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        // 循环法2
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}

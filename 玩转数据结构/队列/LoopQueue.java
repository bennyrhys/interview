package 玩转数据结构.队列;



/**
 * 循环队列
 * 不再复用动态数组，重新定义底层
 * @Author bennyrhys
 * @Date 2020-02-25 21:59
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        // 因为浪费一个位置，用户希望容量c，所有有意识+1
        data = (E[])new Object[capacity + 1];
        // 初始化
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 判满
        if ((tail + 1) % data.length == front)
            // 注意不计有意识浪费的那个空间
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        // size位置千万注意
        size++;
    }

    @Override
    public E dequeue() {
        // 判空
        if (isEmpty())
            throw new IllegalArgumentException("Cantnot dequeue from an empty queue");

        // 出队
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        // 数组动态缩减
        if (size == getCapacity() / 4 && (getCapacity() / 2) != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        // 判空
        if (isEmpty())
            throw new IllegalArgumentException("Cantnot dequeue from an empty queue");

        return data[front];
    }

    // 动态扩容
    private void resize(int newCapacity) {
        // 开辟空间，带上会浪费的那个
        E[] newData = (E[])new Object[newCapacity + 1];
        // 【法1】可以和下方互用
        for (int i = 0; i < size; i++) {
            // 将当前front放在新空间的0起始点
            newData[i] = data[(i + front) % data.length];

            data = newData;
            front = 0;
            tail = size;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity= %d\n", size, getCapacity()));
        res.append("front [");
        // 从front开始，不能取到tail（因为可能比front还小）【法2】
        for (int i = front; i != tail ; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

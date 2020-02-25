package 玩转数据结构.队列;

/**
 * @Author bennyrhys
 * @Date 2020-02-25 20:49
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    // 构造-初始化容量
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    // 构造-无参
    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst() ;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * 存在问题：出队O(n)，其他都是O(1)
     * Queue:[0] tail
     * Queue:[0, 1] tail
     * Queue:[0, 1, 2] tail
     * Queue:[1, 2] tail
     * Queue:[1, 2, 3] tail
     * Queue:[1, 2, 3, 4] tail
     * Queue:[1, 2, 3, 4, 5] tail
     * Queue:[2, 3, 4, 5] tail
     * Queue:[2, 3, 4, 5, 6] tail
     * Queue:[2, 3, 4, 5, 6, 7] tail
     * Queue:[2, 3, 4, 5, 6, 7, 8] tail
     * Queue:[3, 4, 5, 6, 7, 8] tail
     * Queue:[3, 4, 5, 6, 7, 8, 9] tail
     * @param args
     */
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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

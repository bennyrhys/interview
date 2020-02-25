package 玩转数据结构.队列;

/**
 * 队列接口
 * @Author bennyrhys
 * @Date 2020-02-25 20:45
 */
public interface Queue<E> {
    // 计数
    int getSize();
    // 判空
    boolean isEmpty();
    // 入队列
    void enqueue(E e);
    // 出队列
    E dequeue();
    // 获取队列首部元素
    E getFront();

}

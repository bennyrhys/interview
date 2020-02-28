package 玩转数据结构.树.二分搜索树实现集合;

/**
 * 集合-接口
 * @Author bennyrhys
 * @Date 2020-02-28 23:01
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}

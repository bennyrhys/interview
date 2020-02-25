package 玩转数据结构.栈;

/**
 * 面向对象-栈实现的接口
 * @Author bennyrhys
 * @Date 2020-02-25 16:50
 */
public interface Stack<E>{
    // 计数栈中元素
    int getSize();
    // 判空
    boolean isEmpty();
    // 入栈
    void push(E e);
    // 出栈
    E pop();
    // 看栈顶元素
    E peek();


}

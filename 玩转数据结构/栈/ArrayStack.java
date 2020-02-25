package 玩转数据结构.栈;

/**
 * 基于动态数组实现的类
 * 支持泛型继承接口
 * @Author bennyrhys
 * @Date 2020-02-25 16:56
 */
public class ArrayStack<E> implements Stack<E> {

    // 成员变量-动态数组
     Array<E> array;

     //构造函数-传入动态数组溶剂
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    // 构造函数-无参
    public ArrayStack() {
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

    // 查看容积
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}

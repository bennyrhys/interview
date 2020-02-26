package 玩转数据结构.栈;


/**
 * 封装自己的数组-动态数组
 * @Author bennyrhys
 * @Date 2020-02-24 21:30
 */
public class Array<E> {
    // 私有接收数组
    private E[] data;
    // 数组元素个数
    private int size;

    // 构造方法-传入容量
    public Array(int capacity) {
        data = (E[])new Object[capacity]; // java历史遗留问题不能直接new泛型，new Object然后E强制转换
        size = 0;
    }

    // 构造方法-无参 默认数组容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        /*// 边界值-防止指针越界
        if (size == data.length)
            throw new IllegalArgumentException("addLast faild!Array is full! ")

        // 值付给当前size指向位置
        data[size] = e;
        // 将size向后移动一个位置
        size++;*/

        // 复用add方法
        add(size, e);
    }

    // 向数组头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在index位置插入一个新元素e
    public void add(int index, E e) {
        // 防index超出范围
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add faild!Require index < 0 || index > size! ");
        // 边界值-防止指针越界
        if (size == data.length)
            resize(2 * data.length);

        // 从index开始，所有元素后移
        for (int i = size-1; i >= index ; i--) {
                data[i+1] = data[i];
        }

        // index赋值
        data[index] = e;

        // 移动指针
        size++;
    }


    // 查询
    @Override
    public  String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity =%d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    // 获取index索引位置的元素
    public E get(int index) {
        // 限制用户访问空间范围
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        return data[index];
    }

    // 数组元素更新-修改index索引位置的元素为e
    public void set(int index, E e) {
        // 验证用户输入范围合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed.Index is illegal.");

        data[index] = e;
    }

    // 查找数组中是否存在e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {// 泛型-两个类对象比较 equals（值比较）
                return true;
            }
        }
        return false;
    }

    // 查找数组中是否存在e，并返回e的下标
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {// 泛型-两个类对象比较 equals（值比较），不能使用 == （引用比较）
                return i;
            }
        }
        return -1;
    }

    // 删除指定位置的元素,返回删除的元素
    public E remove(int index) {
        // 限制范围
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal!");

        // 预留返回值
        E re = data[index];

        for (int i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }

        // 移动指向【不用担心最后的一位，因为size限制用户根本不会看到】
        size--;
        data[size] = null; // 取消引用，方便垃圾回收

        // 数组动态缩减【防止震荡】
        if (size == data.length / 4 && (data.length / 2) != 0)
            resize(data.length / 2);
        return re;
    }

    // 从数组中删除第一个元素,返回删除元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除数组中出现的元素e【只删除一个】
    public void removeElement(E e) {
        // 查找并返回相同元素的下标位置
        int index = find(e);

        // 存在则删除
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 动态数组
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        // 数据拷贝到新数组
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // 将指针指向新数组
        data = newData;
    }

    // 取出第一个元素
    public E getFirst() {
        return get(0);
    }

    // 取出最后一个元素
    public E getLast() {
          return get(size-1);
    }


}
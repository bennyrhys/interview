package 玩转数据结构.数组;

/**
 * 封装自己的数组
 * @Author bennyrhys
 * @Date 2020-02-24 13:22
 */
public class Array02 {
    // 私有接收数组
    private int[] data;
    // 数组元素个数
    private int size;

    // 构造方法-传入容量
    public Array02(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 构造方法-无参 默认数组容量capacity=10
    public Array02() {
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
    public void addLast(int e) {
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
    public void addFirst(int e) {
        add(0, e);
    }

    // 在index位置插入一个新元素e
    public void add(int index, int e) {
        // 边界值-防止指针越界
        if (size == data.length)
            throw new IllegalArgumentException("add faild!Array is full! ");
        // 防index超出范围
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add faild!Require index < 0 || index > size! ");

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
    int get(int index) {
        // 限制用户访问空间范围
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        return data[index];
    }

    // 数组元素更新-修改index索引位置的元素为e
    void set(int index, int e) {
        // 验证用户输入范围合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed.Index is illegal.");

        data[index] = e;
    }

    // 查找数组中是否存在e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中是否存在e，并返回e的下标
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 删除指定位置的元素,返回删除的元素
    public int remove(int index) {
        // 限制范围
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal!");

        // 预留返回值
        int re = data[index];

        for (int i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }

        // 移动指向【不用担心最后的一位，因为size限制用户根本不会看到】
        size--;
        return re;
    }

    // 从数组中删除第一个元素,返回删除元素
    public int removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 删除数组中出现的元素e【只删除一个】
    public void removeElement(int e) {
        // 查找并返回相同元素的下标位置
        int index = find(e);

        // 存在则删除
        if (index != -1) {
            remove(index);
        }
    }


    public static void main(String[] args) {
       // 验证自定义的数组
        Array02 arr = new Array02(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        //Array: size = 10, capacity =10
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ]
        System.out.println(arr);

        // 指定位置插入元素
        arr.add(1, 100);
        //Array: size = 11, capacity =20
        //[0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        // 首部添加
        arr.addFirst(-2);
        //Array: size = 12, capacity =20
        //[-2, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        // 获取指定位置元素
        int i = arr.get(2);
        // 100
        System.out.println(i);

        // 更新指定位置的值
        arr.set(2, 200);
        // 200
        System.out.println(arr.get(2));

        // 删除索引为2
        arr.remove(2);
        //Array: size = 11, capacity =20
        //[-2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(arr);

        // 删除指定元素
        arr.removeElement(4);
        //Array: size = 10, capacity =20
        //[-2, 0, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println(arr);
    }
}

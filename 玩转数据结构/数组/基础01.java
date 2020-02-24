package 玩转数据结构.数组;

/**
 * 基础创建-遍历
 * @Author bennyrhys
 * @Date 2020-02-24 13:07
 */
public class 基础01 {
    public static void main(String[] args) {
        // 创建对象
        int[] arr = new int[10];

        // 直接初始化
        int[] arr2 = new int[]{1, 2, 3, 4};

        // 改值
        arr[2] = 1;

        // 普通循环
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }

        // 特殊循环
        for (int i : arr2) {
            System.out.print(" "+i);
        }
    }
}

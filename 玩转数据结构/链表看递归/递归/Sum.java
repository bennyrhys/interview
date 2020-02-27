package 玩转数据结构.链表看递归.递归;

/**
 * 体验递归-数组加和
 * @Author bennyrhys
 * @Date 2020-02-27 23:04
 */
public class Sum {

    public static int sum(int[] arr) {
        // 传递数组，并从0开始
        return sum(arr, 0);
    }

    // 计算arr[l……n]这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        // 测试数组加和 = 10
        int[] arr = {1, 2, 3, 4};
        System.out.println(sum(arr));

    }
}

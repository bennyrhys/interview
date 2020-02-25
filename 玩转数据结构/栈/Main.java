package 玩转数据结构.栈;

/**
 * @Author bennyrhys
 * @Date 2020-02-25 16:51
 */
public class Main {
    /**
     * Stack:[0] top
     * Stack:[0, 1] top
     * Stack:[0, 1, 2] top
     * Stack:[0, 1, 2, 3] top
     * Stack:[0, 1, 2, 3, 4] top
     * Stack:[0, 1, 2, 3, 4, 5] top
     * Stack:[0, 1, 2, 3, 4] top
     * @param args
     */
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}

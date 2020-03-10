package 剑指Java.Java多线程与并发;

/**
 * 线程创建-区别run和start
 * @Author bennyrhys
 * @Date 2020-03-10 09:22
 */
public class ThreadTest {
    /**
     * Current main Thread is:main
     * Fight
     * Current Thread is:Thread-0
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                attack();
            }
        };
        System.out.println("Current main Thread is:" + Thread.currentThread().getName());
        t.start();
    }

    /**
     *
     */
    private static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread is:" + Thread.currentThread().getName());
    }
}

package 玩转数据结构.数组;

/**
 * 测试泛型-配合类Array03
 * @Author bennyrhys
 * @Date 2020-02-24 21:07
 */
public class Student {
    private String name;
    private int score;

    public Student(String sname, int sscore) {
        name = sname;
        score = sscore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array03<Student> arr = new Array03<>();
        arr.addLast(new Student("aa", 100));
        arr.addLast(new Student("bb", 200));
        arr.addLast(new Student("cc", 300));
        System.out.println(arr);
    }
}

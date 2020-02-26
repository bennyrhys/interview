package 玩转数据结构.链表;

/**
 * @Author bennyrhys
 * @Date 2020-02-26 21:40
 */
public class Main {
    /**
     * 0->NULL
     * 1->0->NULL
     * 2->1->0->NULL
     * 3->2->1->0->NULL
     * 4->3->2->1->0->NULL
     * 4->3->66->2->1->0->NULL
     * 4->3->2->1->0->NULL
     * 3->2->1->0->NULL
     * 3->2->1->NULL
     * @param args
     */
    public static void main(String[] args) {
        LinkedList2<Integer> linkedList2 = new LinkedList2<>();
        for (int i = 0; i < 5; i++) {
            linkedList2.addFirst(i);
            System.out.println(linkedList2);
        }
        linkedList2.add(2, 66);
        System.out.println(linkedList2);

        linkedList2.remove(2);
        System.out.println(linkedList2);

        linkedList2.removeFirst();
        System.out.println(linkedList2);

        linkedList2.removeLast();
        System.out.println(linkedList2);

    }
}

package 玩转数据结构.栈;


/**
 * 20. 有效的括号-栈
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @Author bennyrhys
 * @Date 2020-02-25 20:06
 */
public class Stack03 {
    /**
     * 判断括号是否匹配
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                // 读取栈中元素将所有左侧括号压入栈
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();

                // 如果此时右侧符号和栈顶不匹配
                if (c == ')' && topChar != '(')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(( new Stack03()).isValid("(){}[]"));
        System.out.println(( new Stack03()).isValid("(}){[]"));
    }
}
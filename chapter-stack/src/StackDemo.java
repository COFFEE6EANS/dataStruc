import java.util.Stack;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/17
 * @Description：
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);

    }
}

/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/20
 * @Description： 基于链表实现的栈。
 */
public class StackBasedLinkedList {
    //栈顶指针
    private Node top = null;

    //压栈
    public void push(int value) {
        Node newNode = new Node(value, null);
        //判断是否是空栈
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    /**
     * 返回栈顶的一个元素，但是不进行出栈操作
     * */
    public int peek(){
        if (top == null)return -1;
        return top.data;
    }
    //弹栈
    public int pop() {
        int res = -1;
        if(top != null){
            res = top.data;
            top = top.next;
        }
        return res;
    }
    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        StackBasedLinkedList stack = new StackBasedLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printAll();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printAll();
    }
}

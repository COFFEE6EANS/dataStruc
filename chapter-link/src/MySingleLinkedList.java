/**
 * @Author guojianfeng.
 * @Date Created in  2018/12/14
 * @Description： 单链表
 *
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */

public class MySingleLinkedList {

    //节点
    public Node head;
    //地址
    public int pos;

    public MySingleLinkedList(){
        this.head = null;
    }



    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node node = new Node(value);
        insertToHead(node);
    }

    public void insertToHead(Node node) {
        if (node == null){
            head = node;
        }
        //将之前的头结点栈地址复制给新的节点的属性节点地址
        //也就是说现在的属性也就是说的next只向之前的节点地址
        node.next = this.head;
        //再将新的节点地址复制给指向首内存地址的指针
        head = node;
        //方法结束  node此栈地址会被销毁
    }

    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }else {
            Node node = head;
            while (node.next!=null){
                node = node.next;
            }
            //新节点的属性节点指针和尾结点属性指针只向相同地址  也就是null
            newNode.next = node.next;
            //再将新节点地址赋值给尾节点地址
            node.next = newNode;
        }

    }
    //通过值找出节点
    public Node findByValue(int value) {
        Node node = head;
        while (node !=null && node.data!=value){
            node = node.next;
        }
        return node;
    }
    //通过地址找出节点
    public Node findByPos(int index) {
        int pos = 0;
        Node node = head;
        while (pos != index && node!=null){
            node = node.next;
            pos++;
        }
        return node;

    }

    class Node{
        public Node next;
        public int data;
        public Node(int data){
            this.data = data;
        }
        //显示此节点
        public void display() {
            System. out.print( data + " ");
        }

    }
}

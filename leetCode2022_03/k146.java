package leetcode.leetCode2022_03;

import java.util.HashMap;

/**
 * 哈希表存储节点实现快速查找
 * 双链表实现快读修改链表
 */
public class k146 {

    public static void main(String[] args) {
        k146 n = new k146(1);
        System.out.println(n.get(6));
        System.out.println(n.get(8));
        n.put(12,1);
        System.out.println(n.get(2));
        n.put(15,11);
        n.put(5,2);
        n.put(1,15);
        n.put(4,2);
        System.out.println(n.get(5));
        n.put(15,15);
    }
    static class Node{
        int val;
        int key;
        Node next;
        Node pre;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail; //末尾节点代表是最长时间未被使用
    HashMap<Integer, Node> map;
    int cap;
    int len;

    public k146(int capacity) {
        this.cap = capacity;
        this.len = 0;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            freRenew(key);
            return map.get(key).val;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        //如果key存在
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            freRenew(key);
            return;
        }

        Node n = new Node(key,value);
        map.put(key,n);
        //不存在时，先判断容量是否已满,是否需要先剔除尾结点
        if(len == cap){
            map.remove(tail.key);
            if(cap > 1){
                tail = tail.pre;
                tail.next = null;
            }
            len--;
        }
        n.next = head;
        //主要是防止第一次运行时
        if(head != null)
            head.pre = n;
        head = n;
        //tail为null,就是cap为1的情况
        if(tail == null)
            tail = n;
        len++;
    }

    public void freRenew(int key){
        Node n = map.get(key);
        if(n.key == head.key)
            return;

        if(tail.key == key && len > 1)
            tail = n.pre;
        if(n.next != null)
            n.next.pre = n.pre;

        n.pre.next = n.next;
        if(len > 1) {
            n.next = head;
            head.pre = n;
            head = n;
        }
    }
}

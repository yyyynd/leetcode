package leetCode2021_05_09;

import java.util.HashMap;

/**
 * 通过存储原链表A中每个节点在B链表中对应的映射关系
 * 然后再次遍历A链表查询A中的random和映射关系完成B中的random的添加
 */
public class k138 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.random = n2;
        n1.next = n2;
        n2.random = n2;
        Node n = new k138().copyRandomList(n1);
        Node tmp = n;
        while (tmp != null){
            System.out.println(tmp.val + "," + tmp.random.val);
            tmp = tmp.next;
        }

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
//        if (head == null)
//            return null;
//
//        Node tmp = head;
//        while (tmp != null){
//            Node newNode = new Node(tmp.val);
//            newNode.next = tmp.next;
//            tmp.next = newNode;
//            tmp = newNode.next;
//        }
//
//        tmp = head;
//        while (tmp != null){
//            Node nextNode = tmp.next.next;
//            if(tmp.random != null)
//                tmp.next.random = tmp.random.next;
//            if(nextNode != null)
//                tmp.next.next = nextNode.next;
//            tmp = nextNode;
//        }
//
//        return head.next;

        HashMap<Node,Node> map = new HashMap<>();
        Node tmp = head;
        Node newHead = new Node(-1);
        Node newTmp = newHead;

        while (tmp != null){
            Node newNode = new Node(tmp.val);
            map.put(tmp,newNode);
            newTmp.next = newNode;
            newTmp = newTmp.next;
            tmp = tmp.next;
        }

        tmp = head;
        newTmp = newHead.next;
        while (tmp != null) {
            newTmp.random = map.get(tmp.random);
            newTmp = newTmp.next;
            tmp = tmp.next;
        }

        return newHead.next;
    }
}

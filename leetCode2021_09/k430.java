package leetCode2021_09;

/**
 * 这题开始做错的原因就是在于没有完成理解每一次递归对child指向的链表到底执行了什么
 * 在每次递归中其实都是对当前的链表进行更新（插入子链表），要注意的是当遍历到最后一个有
 * 子链表的结点时的情况，要记住更新当前travel所指向的结点，更新为插入的子链表的最后结点
 *
 * 也就是说每次插入新链表时，要记住维护travel所指向的结点，这个结点负责遍历以及上一层的链表连接
 */
public class k430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if(head == null)
            return head;
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        Node travel = head;
        while (travel.next != null) {
            if(travel.child != null){
                //获取独立链表的尾节点
                Node childTail = dfs(travel.child);
                childTail.next = travel.next;
                travel.next.prev = childTail;
                //设置下一节点
                reSet(travel);
                //travel设置为先前的下一节点
                travel = childTail;
            } else
                travel = travel.next;
        }//while

        //当前独立链表的最后一个尾结点
        if(travel.child != null){
            //然后寻找到该子链表的尾
            Node childTail = dfs(travel.child);
            //重设其next
            reSet(travel);
            //记得更新一下尾
            travel = childTail;
        }
        return travel;
    }

    //将当前中断点的下一个节点设置为独立链表的头节点
    public void reSet(Node curBreakNode){
        //将独立链表接入当前中断点
        curBreakNode.next =curBreakNode.child;
        curBreakNode.child.prev = curBreakNode;
        curBreakNode.child = null;
    }
}

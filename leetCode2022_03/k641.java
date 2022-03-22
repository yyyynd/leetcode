package leetcode.leetCode2022_03;

public class k641 {
    int cap;
    int len;
    ListNode head;
    ListNode tail;

    public k641(int k) {
        this.cap = k;
        this.len = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if( isFull() )
            return false;

        ListNode newHead = new ListNode(value);
        newHead.next = head;
        if(head != null)
            head.pre = newHead;
        else
            tail = newHead;

        head = newHead;
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if ( isFull() )
            return false;

        ListNode newTail = new ListNode(value);
        if(tail != null)
            tail.next = newTail;
        else
            head = newTail;
        newTail.pre = tail;
        tail = newTail;
        len++;
        return true;
    }

    public boolean deleteFront() {
        if ( isEmpty() )
            return false;
        head = head.next;
        if (head != null)
            head.pre = null;
        else
            tail = null;
        len--;
        return true;
    }

    public boolean deleteLast() {
        if ( isEmpty() )
            return false;
        tail = tail.pre;
        if ( tail != null )
            tail.next = null;
        else
            head = null;
        len--;
        return true;
    }

    public int getFront() {
        if ( isEmpty() )
            return -1;
        return head.val;
    }

    public int getRear() {
        if ( isEmpty() )
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == cap;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode pre;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}

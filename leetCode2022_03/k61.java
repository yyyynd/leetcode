package leetcode.leetCode2022_03;

import java.util.List;

public class k61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode travel = head;
        while ( travel != null){
            len++;
            travel = travel.next;
        }

        if(len == 0 || k % len == 0)
            return head;

        //如果超过长度相当于不变
        k %= len;
        k = len - k;
        travel = head;
        ListNode newHeadPre = null;
        while ( k > 0 ){
            newHeadPre = travel;
            travel = travel.next;
            k--;
        }
        ListNode newHead = travel;
        while (travel.next != null)
            travel = travel.next;
        travel.next = head;
        if(newHeadPre != null)
            newHeadPre.next = null;
        return newHead;
    }
}

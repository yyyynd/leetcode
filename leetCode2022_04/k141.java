package leetcode.leetCode2022_04;

import java.util.List;

public class k141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null){
            if (slow == quick)
                return true;

            slow = slow.next;
            quick = quick.next;
            if (quick != null)
                quick = quick.next;
        }

        return false;
    }
}

package leetcode.leetCode2022_03;

/**
 * 快慢双指针来解决这题，假设存在环，那么意味着非环的部分为a，环的部分长度为b
 * 那么这意味着一个指针走 a+nb步它一定是走到环的入口上
 *
 * 利用快慢指针，快指针一定会在环内追上慢指针（因为快指针先入环所以要追赶慢指针）
 * 那么当快指针追上时一定是追了一个或者数个整圈的，即f = 2m, f = s + nb(s = m)
 * 得f = 2nb,s = nb, 所以 s 如果再走 a步就会形成 a + nb 则就是上述我们谈到的必
 * 走到环入口处的步数了
 */
public class k142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (true){
           if(fast == null || fast.next == null)
               return null;

           fast = fast.next.next;
           slow = slow.next;
           if (fast == slow)
               break;
        }

        fast = head;
        while (fast == slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}

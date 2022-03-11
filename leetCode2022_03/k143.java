package leetcode.leetCode2022_03;

public class k143 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }

    int count = 0;
    int len = 0;
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode travel = head;
        while (travel != null){
            len++;
            travel = travel.next;
        }

        if (len % 2 == 1)
            len++;
        len /= 2;

        fun(head,head);
    }

    public ListNode fun(ListNode left, ListNode right){
        if (right.next != null){
            left = fun(left, right.next);
        }
        if(left == null)
            return null;

        count++;
        if(count == len) {
            right.next = null;
            return null;
        }

        ListNode tmp = left.next;
        left.next = right;
        right.next = tmp;
        return tmp;
    }

}

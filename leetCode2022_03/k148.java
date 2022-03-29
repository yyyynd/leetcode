package leetcode.leetCode2022_03;

/**
 * 利用快慢指针来找到链表的中间位置，不需要统计长度了，省一个循环
 * 且直接就可以让sortList自身做个递归了
 */
public class k148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode travel = head;
        while (travel != null){
            len++;
            travel = travel.next;
        }
        if (len == 0)
            return head;
        return sort(head, len);
    }

    public ListNode sort(ListNode head, int len){
        if (len == 1)
            return head;

        ListNode travel = head;
        ListNode pre = null;

        for (int i = 0; i < len/2; i++) {
            pre = travel;
            travel = travel.next;
        }
        pre.next = null;

        ListNode left = sort(head, len/2);
        ListNode right = sort(travel, len%2 == 0 ? len/2 : len/2 + 1);
        ListNode newHead = new ListNode();
        ListNode insert = newHead;

        while (left != null && right != null){
            if (left.val < right.val){
                insert.next = left;
                left = left.next;
            }else {
                insert.next = right;
                right = right.next;
            }
            insert = insert.next;
        }

        if (left != null)
            insert.next = left;
        else
            insert.next = right;

        return newHead.next;
    }
}

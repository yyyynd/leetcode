package leetCode2021_11;

public class k19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;

        ListNode newHead = new ListNode(0, head);
        ListNode preNode = newHead;
        ListNode fast = head;
        ListNode slow = head;

        while (n != 0){
            fast = fast.next;
            n--;
        }

        while (fast != null){
            fast = fast.next;
            preNode = slow;
            slow = slow.next;
        }
        preNode.next = slow.next;

        return newHead.next;
    }
}

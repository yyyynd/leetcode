package leetcode.leetCode2022_03;

public class k86 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode left = new ListNode();
        ListNode right  = new ListNode();
        ListNode left_h = left;
        ListNode right_h = right;
        ListNode travel = head;
        while (travel != null){
            if(travel.val < x) {
                left.next = travel;
                left = left.next;
            }else{
                right.next = travel;
                right = right.next;
            }
            travel = travel.next;
        }
        left.next = null;
        right.next = null;
        if(left_h.next != null){
            left.next = right_h.next;
            head = left_h.next;
        }

        return head;
    }
}

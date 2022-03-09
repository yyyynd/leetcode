package leetcode.leetCode2022_03;

public class k82 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode H = new ListNode(-101, head);
        ListNode pre = H;
        ListNode left = head;
        ListNode right = head;
        int count = 0;


        while (right != null){
            if(left.val == right.val){
                count++;
                right = right.next;
            }else {
                if(count > 1) {
                    pre.next = right;
                } else
                    pre = left;
                left = right;
                count = 0;
            }
        }//while

        if( count > 1)
            pre.next = null;

        return H.next;
    }
}

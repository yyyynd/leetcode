package leetcode.leetCode2022_03;

public class k147 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        int len = 0;
        ListNode trave = head;
        while (trave != null){
            len++;
            trave = trave.next;
        }

        return sort(head, len);
    }

    public ListNode sort(ListNode l_h,int count){
        if(count == 1)
            return l_h;

        int i = 1;
        int c = count / 2;
        ListNode centre = l_h;

        while ( i < c){
            centre = centre.next;
            i++;
        }

        ListNode r_h = centre.next;
        centre.next = null;
        ListNode left = sort(l_h, c);
        ListNode right = sort(r_h, c + count % 2);

        ListNode head = null;
        ListNode tail = null;

        if(left.val < right.val) {
            head = left;
            left = left.next;
        }else {
            head = right;
            right = right.next;
        }
        head.next = null;
        tail = head;

        while (left != null && right != null){
            if(left.val < right.val ){
                tail.next = left;
                left = left.next;
            }else {
                tail.next = right;
                right = right.next;
            }
            tail.next.next = null;
            tail = tail.next;
        }

        if(left == null){
            tail.next = right;
        }else {
            tail.next = left;
        }

        return head;
    }
}

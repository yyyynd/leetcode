package leetcode.leetCode2022_06;

import java.util.List;

public class k328 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode travel = even.next;
        int flag = 1;
        while (travel != null){
            if (flag == 1){
                even.next = travel.next;
                travel.next = odd.next;
                odd.next = travel;
                odd = travel;
                travel = even.next;
            }else {
                even = travel;
                travel = travel.next;
            }
            flag = -flag;
        }

        return head;
    }
}

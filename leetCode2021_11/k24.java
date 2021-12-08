package leetCode2021_11;

public class k24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

 
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode travel = newHead;

        while (travel.next != null && travel.next.next != null){
//            ListNode curSwapLeft = travel.next;
//            ListNode tmp = curSwapLeft.next.next;
//
//            travel.next = curSwapLeft.next;
//            curSwapLeft.next.next = curSwapLeft;
//            curSwapLeft.next = tmp;
//            travel = curSwapLeft;
            ListNode tmp = travel.next.next;
            travel.next.next = travel.next.next.next;
            tmp.next = travel.next;
            travel.next = tmp;
            travel = tmp.next;

        }

        return newHead.next;
    }
}

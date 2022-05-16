package leetcode.leetCode2022_05;

public class k92 {

    public static void main(String[] args) {
        ListNode n = new ListNode(3, new ListNode(5));
        System.out.println(new k92().reverseBetween(n, 1 ,2));
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l = null;
        ListNode travel = head;
        ListNode end = null;

        for (int i = 1; i < left; i++){
            l = travel;
            travel = travel.next;
        }
        if (l == null)
            l = new ListNode(0, head);

        //跳过最左侧的点
        end = travel;
        travel = travel.next;
        for (int i = left + 1; i <= right; i++){
            ListNode tmp = travel.next;

            end.next = travel.next;
            travel.next = l.next;
            l.next = travel;

            travel = tmp;
        }

        return left == 1 ? l.next : head;
    }
}

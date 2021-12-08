package leetCode2021_05_09;

public class o_k22 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ans = null;
        int count = 0;
        int i = 0;
        ans = head;

        for (i = 0; i < k-1; i++)
            head = head.next;

        if(i != k-1)
            return null;

        while (head.next != null){
            ans = ans.next;
            head = head.next;
        }

        return ans;
    }
}

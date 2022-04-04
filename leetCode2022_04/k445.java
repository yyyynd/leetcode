package leetcode.leetCode2022_04;

public class k445 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len_1 = 0;
        int len_2 = 0;
        ListNode travel = l1;

        while (travel != null) {
            travel = travel.next;
            len_1++;
        }

        travel = l2;
        while (travel != null) {
            travel = travel.next;
            len_2++;
        }

        travel = len_1 > len_2 ? l2 : l1;
        int len = Math.abs(len_1 - len_2);
        for (int i = 0; i < len; i++){
            ListNode newHead = new ListNode(0);
            newHead.next = travel;
            travel = newHead;
        }

        if (dfs(len_1 > len_2 ? l1 : l2 , travel)){
            ListNode res = new ListNode(1);
            res.next = len_1 > len_2 ? l1 : l2;
            return res;
        }

        return len_1 > len_2 ? l1 : l2;
    }

    public boolean dfs(ListNode l1, ListNode l2){
        boolean flag = false;
        if (l1.next != null)
            flag = dfs(l1.next, l2.next);

        l1.val = l1.val + l2.val + (flag ? 1 : 0);
        flag = l1.val >= 10;
        l1.val %= 10;

        return flag;
    }

}

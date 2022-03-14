package leetcode.leetCode2022_03;

/**
 *
 */
public class k234 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    int count = 0;
    int len = 0;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null )
            return true;

        ListNode travel = head;
        ListNode fast = head;
        ListNode slow = head;
        //反转slow遍历过的节点
        ListNode pre = null;
        ListNode ppre = null;
//        while (travel != null){
//            len++;
//            travel = travel.next;
//        }

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
            pre.next = ppre;
            ppre = pre;
        }
        //在点数为奇数的时候，fast是指到链表尾结点，而slow正好直到的是中间节点，无需进行判断
        //故slow设置再指向下一个节点
        if (fast != null)
            slow = slow.next;

        while (pre != null){
            if(pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

//    public ListNode dfs(ListNode left, ListNode right){
//        if(right.next != null){
//            left = dfs(left, right.next);
//        }
//        if(count == len)
//            return null;
//
//        if(left.val == -1)
//            return new ListNode(-1);
//
//        if (left.val == right.val) {
//            len++;
//            return left.next;
//        }
//
//        return new ListNode(-1);
//    }
}

package leetcode.leetCode2022_09;

import java.util.Arrays;
import java.util.HashSet;

public class k817 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        HashSet<Integer> dictionary = new HashSet<>();
        for (int n : nums)
            dictionary.add(n);

        while (head != null){
            if ( dictionary.contains(head.val) && (head.next == null || !dictionary.contains(head.next.val)))
                ans++;

            head = head.next;
        }

        return ans;
    }
}

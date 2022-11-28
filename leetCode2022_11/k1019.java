package leetcode.leetCode2022_11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k1019 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[0];
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count += 1;
        }

        int[] ans = new int[count];
        LinkedList<int[]> stack = new LinkedList<>();
        int index = 0;

        stack.add(new int[]{index, head.val});
        head = head.next;
        index += 1;

        while (head != null){
            while (!stack.isEmpty()){
                int[] cur = stack.pollLast();
                if (cur[1] < head.val)
                    ans[cur[0]] = head.val;
                else{
                    stack.add(cur);
                    break;
                }
            }
            stack.add(new int[]{index, head.val});
            index += 1;
            head = head.next;
        }

        while (!stack.isEmpty()){
            int[] cur = stack.pollLast();
            ans[cur[0]] = 0;
        }
        return ans;
    }


}

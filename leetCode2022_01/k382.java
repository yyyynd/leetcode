package leetCode2022_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class k382 {
    public class ListNode {
        int val;ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    class Solution {
        List<ListNode> list = new ArrayList<>();
        Random random = new Random(20220116);
        public Solution(ListNode head) {
            while (head != null){
                list.add(head);
                head = head.next;
            }
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index).val;
        }
    }
}

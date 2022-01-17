package leetCode2022_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * 这题其实就是为了保障每个结果被选中的概率都是一样的即1/n
 *
 * 蓄水池抽样法的优势就在于不需要知道整个样本集合的容量到底是多少
 * 下述的模拟写法需要预先统计样本数量
 */
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

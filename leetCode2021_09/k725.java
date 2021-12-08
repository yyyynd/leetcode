package leetCode2021_09;

import java.util.Arrays;

public class k725 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(0);
        ListNode tmp = head;
        for(int i = 1; i <= 4; i++){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        new k725().splitListToParts(head,3);
    }
    public ListNode[] splitListToParts(ListNode head, int k){
        int length = 0;
        ListNode tmp = head;
        ListNode[] ans = new ListNode[k];
        //不考虑剩余的情况，k段每一段最长的长度
        int maxSegLength;
        //需要调整的段的数量
        int adjustSegNum;
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        //链表为0直接返回
        if (length == 0)
            return ans;
        //处理长度比k小的情况
        if (k > length){
            for (int i = 0; i < length; i++) {
                ans[i] = head;
                tmp = head.next;
                head.next = null;
                head = tmp;
            }
            return ans;
        }
        maxSegLength = length/ k;
        adjustSegNum = length - maxSegLength * k;

        ListNode travel = head;
        for (int i = 0; i < k; i++){
            int flag = i < adjustSegNum ? 1 : 0;
            ListNode curSegHead = travel;
            for (int j = 0; j < maxSegLength + flag - 1 ; j++)
                travel = travel.next;
            tmp = travel.next;
            travel.next = null;
            travel = tmp;
            ans[i] = curSegHead;
        }

        return ans;
    }
}

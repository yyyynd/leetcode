package leetcode.leetCode2022_03;

/**
 * 这里采用的是归并排序
 * 还有一种思路是，每次都选择一个节点进行插入确实是比较浪费时间的
 * 但如果每次选取插入点时，如果后续的节点比前一个点大，那么其就是有序的
 * 可以一直选择点，直到后续的点没有前置点大，说明无序了，直接将这一部分插入
 * 这个方法问题就是搜索插入点比二分归并耗时，
 */
public class k147 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        int len = 0;
        ListNode trave = head;
        while (trave != null){
            len++;
            trave = trave.next;
        }

        return sort(head, len);
    }

    public ListNode sort(ListNode l_h,int count){
        if(count == 1)
            return l_h;

        int i = 1;
        int c = count / 2;
        ListNode centre = l_h;

        while ( i < c){
            centre = centre.next;
            i++;
        }

        ListNode r_h = centre.next;
        centre.next = null;
        ListNode left = sort(l_h, c);
        ListNode right = sort(r_h, c + count % 2);

        ListNode head = null;
        ListNode tail = null;

        if(left.val < right.val) {
            head = left;
            left = left.next;
        }else {
            head = right;
            right = right.next;
        }
        head.next = null;
        tail = head;

        while (left != null && right != null){
            if(left.val < right.val ){
                tail.next = left;
                left = left.next;
            }else {
                tail.next = right;
                right = right.next;
            }
            tail.next.next = null;
            tail = tail.next;
        }

        if(left == null){
            tail.next = right;
        }else {
            tail.next = left;
        }

        return head;
    }
}

package leetcode.leetCode2022_03;

public class k225 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode pre;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
    }

    ListNode stackHead = new ListNode(-1);

    public k225() {

    }

    public void push(int x) {
        ListNode newHead = new ListNode(x);
        stackHead.next = newHead;
        newHead.pre = stackHead;
        stackHead = newHead;
    }

    public int pop() {
        int res = stackHead.val;
        stackHead = stackHead.pre;
        stackHead.next = null;
        return res;
    }

    public int top() {
        return stackHead.val;
    }

    public boolean empty() {
        return stackHead.val == -1;
    }
}

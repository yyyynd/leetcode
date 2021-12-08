package leetCode2021_05_09;

public class k206 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
         ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
  }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode new_head = head;
        //找到尾节点
        while (new_head.next != null)
            new_head = new_head.next;

        //比引用就行
        while (head != new_head){
            ListNode t = head.next;
            head.next = new_head.next;
            new_head.next = head;
            //head遍历next点
            head = t;
        }

        return new_head;
    }
}

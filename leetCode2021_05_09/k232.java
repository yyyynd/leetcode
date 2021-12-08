package leetCode2021_05_09;

public class k232 {

    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode removeElements(ListNode head, int val) {
        ListNode myHead = new ListNode();
        ListNode preNode = null;
        ListNode travel = null;

        myHead.next = head;
        preNode = myHead;
        travel = myHead.next;
        while (travel != null){
            if(travel.val == val){
                preNode.next = travel.next;
            }else{
                preNode = travel;
            }
            travel = travel.next;
        }

        return myHead.next;
    }
}

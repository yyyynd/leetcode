package leetCode2021_05_09;

public class k2 {

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean i = false;//表示上一次运算是否产生进位
        ListNode result = new ListNode();//头节点
        ListNode travel = result;
        ListNode preNode = null;

        while (l1 != null && l2 != null){
            //判断是否上一次运算产生进位
            if(i){
                travel.val = (l1.val + l2.val +1) % 10;
                //判断本次运算是否产生进位(进位赋true，否则false
                i = l1.val + l2.val + 1 >= 10;
            }else{
                travel.val = (l1.val + l2.val) % 10;
                i = l1.val + l2.val >= 10;
            }
            travel.next = new ListNode();
            preNode = travel;//保存前继点
            //迭代到后续节点
            l1 = l1.next;
            l2 = l2.next;
            travel = travel.next;
        }

        while (l1 != null){
            //处理之前两两相加还是产生了进位
            if(i){
                travel.val = (l1.val +1)%10;
                i = l1.val +1 >= 10;
            }else{
                travel.val = l1.val;
            }
            travel.next = new ListNode();
            preNode = travel;
            travel = travel.next;
            l1 = l1.next;
        }

        while (l2 != null){
            if(i){
                travel.val = (l2.val +1)%10;
                i = l2.val +1 >= 10;
            }else{
                travel.val = l2.val;
            }
            travel.next = new ListNode();
            preNode = travel;
            travel = travel.next;
            l2 = l2.next;
        }
        //如果所有链表遍历完了还是产生了进位(比如全是9,一直进1，但到加到最后遍历完了还有进位)
        if(i){
            travel.val = 1;
            travel.next = null;
        }else{
            //如果没有产生遍历完继续进位，则把最后一次循环创建的结点删除
            preNode.next = null;
        }
        return result;
    }
}

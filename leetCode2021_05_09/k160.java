package leetCode2021_05_09;

public class k160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode travel = null;
        ListNode travel_2 = null;

        travel = headA;
        while (travel != null){
            lengthA++;
            travel = travel.next;
        }

        travel = headB;
        while (travel != null){
            lengthB++;
            travel = travel.next;
        }

        if(lengthA > lengthB){
            travel = headA;
            travel_2 = headB;
        }else {
            travel = headB;
            travel_2 = headA;
        }

        for (int i = 0; i < Math.abs(lengthA - lengthB); i++)
            travel = travel.next;

        //如果没有相交点则应该两个遍历的引用都为null（意味着循环到最后了）
        for(int i = 0; i < Math.min(lengthA,lengthB); i++){
            //相同引用就行
            if(travel == travel_2)
                break;
            travel = travel.next;
            travel_2 = travel_2.next;
        }

        return travel;
    }
}

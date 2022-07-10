package leetcode.leetCode2022_07;

import java.util.LinkedList;
import java.util.List;

public class k729 {

    public class CalenderNode{
        int start;
        int end;
        CalenderNode next;

        public CalenderNode() {
        }

        public CalenderNode(int start, int end, CalenderNode next) {
            this.start = start;
            this.end = end;
            this.next = next;
        }
    }

    CalenderNode head;

    public k729() {
        head = new CalenderNode();
    }

    public boolean book(int start, int end) {
        //如果当前整个链表为空
        if (head.next == null){
            head.next = new CalenderNode(start, end, null);
            return true;
        }

        CalenderNode travel = head.next;
        //判断是否可以头插
        if (end <= travel.start){
            if (end == travel.start)
                travel.start = start;
            else
                head.next = new CalenderNode(start, end, travel);
            return true;
        }

        //判断在两个区间后面寻找插入点,重叠，和可插入
        while (travel.next != null){
            if (travel.next.end <= start)
                travel = travel.next;
            else if (travel.end > start || travel.next.start < end){
                return false;
            }else{
                if (travel.end == start)
                    travel.end = end;
                else if (travel.next.start == end)
                    travel.next.start = start;
                else
                    travel.next = new CalenderNode(start,end, travel.next);

                return true;
            }
        }

        //判断是否可以加到队尾
        if (travel.end <= start){
            if (travel.end == start)
                travel.end = end;
            else
                travel.next = new CalenderNode(start, end, null);

            return true;
        }

        return false;
    }
}

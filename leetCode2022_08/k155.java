package leetcode.leetCode2022_08;

import java.util.LinkedList;

public class k155 {
    public static void main(String[] args) {
        k155 t = new k155();
        t.push(512);
        t.push(-1);
        t.push(-1);
        t.push(512);
        t.pop();
        System.out.println(t.getMin());
        t.pop();
        System.out.println(t.getMin());
        t.pop();
        System.out.println(t.getMin());
    }

    LinkedList<Integer> min;
    int curMin;
    LinkedList<Integer> stack;

    public k155() {
        this.min = new LinkedList<>();
        this.min.add(Integer.MAX_VALUE);//init
        this.curMin = Integer.MAX_VALUE;
        this.stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.addFirst(val);
        //如果新入栈的值小于等于最小值，则新建一个记录点
        if (curMin >= val) {
            min.addFirst(val);
            curMin = val;
        }
    }
    public void pop() {
        int pop = stack.poll();
        if (curMin == pop) {
            min.poll();
            curMin = min.getFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return min.getFirst();
    }
}

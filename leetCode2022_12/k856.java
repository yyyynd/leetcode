package leetcode.leetCode2022_12;


import java.util.LinkedList;

/**
 * 这里这个遇到（ 加入一个占位符0的操作是这思路的核心
 * 因为这个0首先可以保证A+B操作的实现，其次后续我们看到再尝试合并邻接的时候
 * 之前的占位符也会被弹出，但其实这是相当于在更新这个占位符的值
 * 所以实际上每个占位代表的都是一个括号的包围部分的值大小
 * 我们其实就是在不断更新这些值
 */
public class k856 {
    public int scoreOfParentheses(String s) {
        int len = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        for (int i = 0; i < len; i++){
            if (s.charAt(i) == '(') {
                stack.add(0);
            } else {
                int cur = stack.pollLast();
                //这一步+邻接的值
                stack.add(stack.pollLast() + Math.max(1, cur * 2));
            }
        }

        return stack.pollLast();
    }

}

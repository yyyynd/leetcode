package leetcode.leetCode2022_12;

import java.util.LinkedList;

public class k946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < popped.length;){
            if (stack.isEmpty()) {
                stack.add(pushed[j]);
                j += 1;
            }

            if (stack.peekLast() == popped[i]){
                stack.pollLast();
                i += 1;
            }else if (j == pushed.length) {
                return false;
            }else if (j < pushed.length){
                stack.add(pushed[j]);
                j += 1;
            }
        }
        return true;
    }
}

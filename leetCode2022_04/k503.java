package leetcode.leetCode2022_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class k503 {
    public static void main(String[] args) {
        System.out.println(new k503().nextGreaterElements(new int[]{1,1,1,1,1}));
    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int iterateLimit = len * 2 - 1;
        int[] res = new int[len];
        Arrays.fill(res, -1);
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < len; i++){
//            int curNum = nums[i];
//            while (!list.isEmpty()){
//                if (nums[list.peekLast()] < curNum)
//                    res[list.pollLast()] = curNum;
//                else
//                    break;
//            }
//
//            list.add(i);
//        }
//
//        if (list.size() != 1){
//            int head = nums[list.poll()];
//            while (!list.isEmpty()){
//                int i = list.pollLast();
//                if (head > nums[i])
//                    res[i] = head;
//                else
//                    break;
//            }
//        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= iterateLimit; i++){
            int curNum = nums[i % len];
            while (!stack.isEmpty()){
                if (nums[stack.peek()] < curNum)
                    res[stack.pop()] = curNum;
                else
                    break;
            }

            if(i < len)
                stack.push(i);
        }

        return res;
    }
}

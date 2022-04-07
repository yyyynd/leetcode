package leetcode.leetCode2022_04;

import java.util.Arrays;
import java.util.Stack;

public class k316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int[] flag = new int[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c - 'a';
            count[index]--;

            if(flag[index] != 0)
                continue;

            while (!stack.isEmpty()){
                char top = stack.peek();
                if (top >= c && count[top - 'a'] != 0)
                    flag[stack.pop() - 'a'] = 0;
                else
                    break;
            }
            stack.push(c);
            flag[index] = 1;
        }
        char[] res = new char[stack.size()];
        for (int i = res.length -1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return String.valueOf(res);
    }
}

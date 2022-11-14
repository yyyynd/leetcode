package leetcode.leetCode2022_11;

import java.util.LinkedList;

/**
 * 这题的思路是利用栈，我们需要保证整个字典序最小，同时包含所有种类字符
 * 一个很重要的思路就是，这个和数字大小一样，只要有一个相同位更大（小），那么
 * 整个该结果就比另一个更大（小），如果新遇到一个字符，它比当前加入的字符都要小
 * 那么就考虑是否能放到尽可能的前面，那么什么时候可以放呢，就是如果前面的字符后面
 * 还有机会选到的话，就可以剔除栈，来把新字符放进去，因为后续的字符还能再次加入
 * 如果没有了，则代表着这个字符虽然字典序更大，但为了保证包含全部种类的字符串，
 * 就一定需要先把这个字符放进去，即需要优先选择
 */
public class k1081 {
    public static void main(String[] args) {
        System.out.println(new k1081().smallestSubsequence("cbacdcbc"));
    }
    public String smallestSubsequence(String s) {
        int[] memo = new int[26];
        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a'] += 1;
        }

        LinkedList<Character> stack = new LinkedList<>();
        int[] mark = new int[26];
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            int index = cur - 'a';
            if (mark[index] == 1) {
                memo[index] -= 1;
                continue;
            }
            while (!stack.isEmpty()){
                char comp = stack.peekLast();
                if (comp > cur && memo[comp - 'a'] != 0) {
                    mark[comp - 'a'] = 0;
                    stack.pollLast();
                }else
                    break;
            }
            stack.add(cur);
            memo[index] -= 1;
            mark[index] = 1;
        }

        StringBuilder ans = new StringBuilder();
        for (Character c : stack)
            ans.append(c);
        return ans.toString();
    }
}

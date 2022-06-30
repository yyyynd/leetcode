package leetcode.leetCode2022_06;

import java.util.*;

public class k1239 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.add("f")
        System.out.println(new k1239().maxLength(list));
    }

    int ans = 0;
    int[] comp;
    int[] compLen;
    int limit = 0;
    int arrLen;
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int maxLength(List<String> arr) {
        this.comp = new int[arr.size()];
        this.compLen = new int[arr.size()];
        this.arrLen = arr.size();
        for (int j = 0; j < arr.size(); j++){
            String s = arr.get(j);
            int tmp = 0;
            for (int i = 0; i < s.length(); i++){
                int index = s.charAt(i) - 'a';
                if ((tmp >> index & 1) == 1) {
                    tmp = 0;
                    break;
                }
                tmp = tmp | 1 << index;
            }
            comp[j] = tmp;
            compLen[j] = tmp == 0 ? 0 : s.length();
            limit |= tmp;
        }

        int tmp = 0;
        for (int i = 0; i < 26; i++)
            if ((limit >> i & 1) == 1)
                tmp++;

        limit = tmp;

        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int index, int curComp, int curLen){
        if (ans >= limit)
            return;

        if (index == arrLen) {
            ans = Math.max(ans, curLen);
            return;
        }

        if ((curComp & comp[index]) == 0)
            dfs(index + 1, curComp | comp[index], curLen + compLen[index]);

        dfs(index + 1,curComp, curLen);
    }
}

package leetcode.leetCode2022_09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class k792 {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        LinkedList<String>[] bucket = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            bucket[i] = new LinkedList<>();

        for (String word : words){
            if (word.length() > s.length())
                continue;
            bucket[word.charAt(0) - 'a'].add(word);
        }

        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            char cur = sArr[i];
            LinkedList<String> curList = bucket[cur - 'a'];
            int len = curList.size();
            for (int j = 0; j < len; j++){
                String curStr = curList.poll();
                if (curStr.length() == 1){
                    ans++;
                }else {
                    String newStr = curStr.substring(1);
                    bucket[newStr.charAt(0) - 'a'].add(newStr);
                }
            }
        }

        return ans;
    }
}

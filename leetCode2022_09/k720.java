package leetcode.leetCode2022_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class k720 {
    public static void main(String[] args) {
        new k720().longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"});
    }


    public String longestWord(String[] words) {
        HashSet<String> memo = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String ans = "";
        memo.add("");
        for (String word : words){
            int wordLen = word.length();
            //首先查看前置字符串是否存在
            if ( !memo.contains(word.substring(0, wordLen - 1)) )
                continue;

            //如果长度更大直接替换
            if (ans.length() < wordLen){
                ans = word;
            }else if (ans.length() == wordLen){
                //如果长度相同则比较字典序
                for (int i = 0; i < wordLen; i++){
                    int t = ans.charAt(i) - word.charAt(i);
                    if(t < 0)
                        break;
                    else if (t > 0){
                        ans = word;
                        break;
                    }
                }
            }//if

            memo.add(word);
        }

        return ans;
    }
}

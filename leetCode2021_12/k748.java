package leetCode2021_12;

import java.util.Arrays;

public class k748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];
        int count = 0;
        String ans = null;
        for (char c : licensePlate.toCharArray()){
            if( c >= 'a' && c <= 'z') {
                license[c - 'a']++;
                count++;
            }
            else if( c >= 'A' && c <= 'Z') {
                license[c - 'A']++;
                count++;
            }
        }

        int preWordLen = Integer.MAX_VALUE;
        for (String w : words){
            if(preWordLen <= w.length())
                continue;
            int[] tmp = Arrays.copyOf(license, license.length);
            int curWordCount = 0;
            for(int i = 0; i < w.length(); i++){
                char curChar = w.charAt(i);
                int j;
                if( curChar >= 'a' && curChar <= 'z')
                    j = curChar - 'a';
                else if( curChar >= 'A' && curChar <= 'Z')
                    j = curChar - 'A';
                else
                    continue;

                if(tmp[j] != 0){
                    tmp[j]--;
                    curWordCount++;
                }
            }//for
            if(curWordCount == count){
                preWordLen = w.length();
                ans = w;
            }
        }//for

        return ans;
    }
}

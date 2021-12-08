package leetCode2021_11;

import java.util.Arrays;
import java.util.Comparator;

public class k318 {
    public int maxProduct(String[] words) {
//        Arrays.sort(words, Comparator.comparingInt(String::length));
        int ans = 0;
        int[] comp = new int[words.length];

        //用26位数统计单词所拥有的字母种类
        for (int i = 0; i < words.length; i++){
            String w = words[i];
            int tmp = 0;
            for (int j = 0; j < w.length(); j++)
                tmp  |=  1 << w.charAt(j) - 'a';
            comp[i] = tmp;
        }

        for (int i = words.length - 1; i >= 1; i--){
            //如果本轮在不考虑是否符合条件的情况下最大乘积都没当前最大值大，则不可能再更新结果
//            if (words[i].length() * words[i-1].length() <= ans)
//                return ans;
            for (int j = i - 1; j >= 0; j--){
                if((comp[i] & comp[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }//for
        }//for

        return ans;
    }
}

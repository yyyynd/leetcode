package leetCode2021_05_09;

import java.util.*;

public class k139 {

    public static void main(String[] args) {
        List<String> list;
        String[] arr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"
                ,"aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        list = Arrays.asList(arr.clone());
        System.out.println(new k139().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
                "aaaaaaaaaaaaaaaaaaaaaaaaaab" ,list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        int[] dp = new int[length];

        if(length == 0)
            return false;
        for (int i = 0; i < length; i++)
            dp[i] = -1;

        //将字典所有的字符串放入哈希集
        HashSet<String> hashWordDict = new HashSet<>(wordDict);
        //开始逐个匹配
        for(int start = 0; start < length;){
            for (int end = start; end < length;end++){
                String curWord = s.substring(start,end+1);
                //判断当前字符串是否存在于字典中
                if(hashWordDict.contains(curWord)) {
                    dp[end] = start;
                    start = end+1;
                    break;
                }//if
                //这里假设第一个单词匹配上了，开始匹配后续的单词
                //也就是开始点下标不是0.但end已经到最后了还无匹配成功
                //所以可以通过之前存储的前置点，重新匹配上一个单词
                if(start != 0 && end == length-1){
                    //end重置为上一范围的右端点
                    end = start-1;
                    //start重置为上一范围左端点
                    start = dp[end];
                    //将上一范围的dp重置为-1
                    dp[end] = -1;
                //第一个单词就无匹配结果，退出循环
                } else if(start == 0 && end == length-1)
                    start = length;
            }//for (int end
        }//for(int start

        return dp[length-1] != -1;
    }
}

package leetCode2021_12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class k1078 {
    public static void main(String[] args) {
        System.out.println(new k1078().findOcurrences("we we we we will rock you",
                "we",
                "we"));
    }
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new LinkedList<>();
        for(int i = 2; i < words.length; i++){
            if(words[i-2].equals(first) && words[i-1].equals(second))
                ans.add(words[i]);
        }
//        for (String word : words){
//            if(count == 2) {
//                ans.add(word);
//                count = 0;
//            }
//
//            if(word.equals(first) && count == 0)
//                count = 1;
//            else if(word.equals(second) && count == 1)
//                count++;
//            else
//                count = 0;
//        }

        return ans.toArray(new String[0]);
    }
}

package leetCode2021_09;

import java.util.LinkedList;
import java.util.List;

public class k524 {
    public static void main(String[] args) {
        LinkedList<String> dit = new LinkedList<>();
        dit.add("ewaf");
        dit.add("awef");
        System.out.println(new k524().findLongestWord("aewfafwafjlwajflwajflwaf",dit));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        int curMax = 0;
        String ans = "";
        int length_s = s.length();

        for (String d : dictionary){
            int length_d = d.length();
            if(length_d < length_s && length_d > curMax && judge(s,d)) {
                ans = d;
                curMax = d.length();
            }else if (length_d == curMax && judge(s,d) && compare(ans,d)){
                ans = d;
                curMax = d.length();
            }
        }

        return ans;
    }

    public boolean compare(String s, String d){
        char[] str_s = s.toCharArray();
        char[] str_d = d.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if(str_s[i] != str_d[i])
                return str_s[i] - str_d[i] > 0;
        }

        return false;
    }

    public boolean judge(String s, String d){
        int index_s = 0;
        int index_d = 0;
        int length_s = s.length();
        int length_d = d.length();
        char[] str_s = s.toCharArray();
        char[] str_d = d.toCharArray();
        while (index_s < length_s && index_d < length_d){
            if(length_s - index_s < length_d - index_d)
                return false;
            if(str_s[index_s] == str_d[index_d]){
                index_s++;
                index_d++;
            }else
                index_s++;
        }

        return index_d == d.length();
    }
}

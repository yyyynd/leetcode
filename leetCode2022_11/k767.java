package leetcode.leetCode2022_11;

import java.util.List;

public class k767 {
    public static void main(String[] args) {
        System.out.println(new k767().reorganizeString("aab"));
    }
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c - 'a'] += 1;
        }

        int max = 0;
        for (int i = 0; i < 26; i++)
            if (count[max] < count[i])
                max = i;


        if (count[max] > (s.length()%2 == 0 ? s.length()/2 : s.length()/2 + 1))
            return "";

        StringBuilder[] stringBuilders = new StringBuilder[count[max]];
        int tmp = count[max];
        while (count[max] > 0)
            stringBuilders[--count[max]] = new StringBuilder().append(Character.toChars('a' + max));

        int mark = 0;
        for (int i = 0; i < 26; i++){
            while (count[i] > 0){
                stringBuilders[mark].append(Character.toChars('a' + i));
                mark = (mark + 1) % tmp;
                count[i] -= 1;
            }
        }

        for (int i = 1; i < stringBuilders.length; i++)
            stringBuilders[0].append(stringBuilders[i]);
        return stringBuilders[0].toString();
    }
}

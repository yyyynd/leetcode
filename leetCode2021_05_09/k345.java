package leetCode2021_05_09;

import java.util.HashSet;

public class k345 {
    public static void main(String[] args) {
        System.out.println(new k345().reverseVowels("A"));
    }
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = str.length-1;
        while (i < j){
            while (!set.contains(str[i])  && i < j)
                i++;
            //上述中的i < j和 i==j都限制了到这个循环的时候j必大于i
            while (!set.contains(str[j]) && j > i)
                j--;

            if(i < j) {
                char tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
                i++;
                j--;
            }
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}

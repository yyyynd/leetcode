package leetcode.leetCode2022_02;

public class k2000 {
    public String reversePrefix(String word, char ch) {
        StringBuilder res = new StringBuilder();
        int index =  -1;
        for (int i = word.length() - 1; i >= 0; i--){
            if(word.charAt(i) == ch)
                index = i;
        }
        for (int i = index; i >= 0; i--){
            res.append(word.charAt(i));
        }

        res.append(word.substring(index+1));
        return res.toString();
    }
}

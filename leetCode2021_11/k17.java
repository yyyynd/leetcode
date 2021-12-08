package leetCode2021_11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class k17 {

    LinkedList<String> res;
    int len = 0;
    char[][] chars = {{'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        this.res = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1')
                this.len++;
        }
        if(this.len == 0)
            return res;

        return dfs(digits.toCharArray(), 0);
    }

    public LinkedList<String> dfs(char[] digits, int index){
        LinkedList<String> res = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        if(index == digits.length) {
            res.add("");
            return res;
        }

        if(digits[index] == '1')
            return dfs(digits, index + 1);

        LinkedList<String> preRes = dfs(digits, index + 1);
        int num = digits[index] - '2';
        for (String preStr : preRes){
            stringBuilder.append(preStr);
            for (int i = 0; i < chars[num].length; i++) {
                res.add(stringBuilder.insert(0, chars[num][i]).toString());
                stringBuilder.deleteCharAt(0);
            }
            stringBuilder.delete(0,stringBuilder.length());
        }

        return res;
    }
}

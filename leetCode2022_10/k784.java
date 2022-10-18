package leetcode.leetCode2022_10;

import java.util.LinkedList;
import java.util.List;

public class k784 {

    public List<String> letterCasePermutation(String s) {
        return dfs(0, s);
    }

    public List<String> dfs (int index, String s) {
        List<String> subAns = new LinkedList<>();
        if (index == s.length()) {
            subAns.add("");
            return subAns;
        }

        char cur = s.charAt(index);
        List<String> t = dfs(index + 1, s);


        if (cur < 65){//数字
            for (String sub : t)
                subAns.add(cur + sub);
        }else if (cur >= 97){
            for (String sub : t){
                subAns.add(cur + sub);
                subAns.add( (char)(cur - 32) + sub);
            }
        }else {
            for (String sub : t){
                subAns.add(cur + sub);
                subAns.add( (char)(cur + 32) + sub);
            }
        }

        return subAns;

    }
}

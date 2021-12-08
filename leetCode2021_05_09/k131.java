package leetCode2021_05_09;

import java.util.LinkedList;
import java.util.List;

public class k131 {

    public static void main(String[] args) {
        System.out.println(new k131().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        if(length == 1){
            List<List<String>> list = new LinkedList<>();
            LinkedList<String> only = new LinkedList<>();
            only.add(s);
            list.add(only);
            return list;
        }

        for(int i = length-1; i >= 0; i--){
            for (int j = i; j < length; j++){
                boolean b = s.charAt(i) == s.charAt(j);
                if(j-i <=2 && b)
                    dp[i][j] = true;
                else if (b && dp[i+1][j-1])
                    dp[i][j] = true;
            }
        }

        return fun(0,length,dp,s);
    }

    private List<List<String>> fun(int start,int length,boolean[][] dp,String s){
        List<List<String>> list = new LinkedList<>();

        //最后一字符必为回文，直接返回了
        if(start == length-1) {
            List<String> stringArr = new LinkedList<>();
            stringArr.add(s.substring(start,length));
            list.add(stringArr);
            return list;
        }

        for(int i = start; i < length; i++){
            //能形成回文才继续
            if(!dp[start][i])
                continue;
            String curString = s.substring(start,i+1);
            //用完所有字符了，结束循环，所以start永远不等于length
            if(i == length-1){
                List<String> stringArr = new LinkedList<>();
                stringArr.add(curString);
                list.add(stringArr);
                break;
            }
            //获取后续范围为回文的子串集合
            List<List<String>> followStringList = fun(i+1,length,dp,s);

            //将每一个符合条件的一维数组集合和当前范围形成的子串组合成新数组
            //为什么这里不检查null，因为理论上必存在全为单个字符的数组
            for (List<String> l : followStringList){
                List<String> stringArr = new LinkedList<>();
                stringArr.add(curString);
                stringArr.addAll(l);
                list.add(stringArr);
            }
        }//for

        return list;
    }

}

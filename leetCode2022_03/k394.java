package leetcode.leetCode2022_03;

public class k394 {

    public static void main(String[] args) {
        System.out.println(new k394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    int len;
    int index = 0;

    public String decodeString(String s) {
        this.len = s.length();
        StringBuilder res = new StringBuilder();
        while (index < len)
            res.append(dfs(s));
        return res.toString();
    }

    public String dfs(String s){
        StringBuilder resBuilder = new StringBuilder();

        int fre = 0;
        char c = s.charAt(index);
        //假设遇到数字了
        if( c - '0' <= 9){
            while (c  != '[') {
                fre = fre * 10 + c - '0';
                index++;
                c = s.charAt(index);
            }
            index++;//过滤[
        }
        //理论上假设我们现在还是在一个方括号内，直到第一个']'才退出当的添加
        while ( index < len ){
            if (s.charAt(index) == ']')
                break;
            if( !Character.isLowerCase(s.charAt(index))) {
                resBuilder.append(dfs(s));
                continue;
            }
            else
                resBuilder.append(s.charAt(index));
            index++;
        }
        index++; //过滤]
        if(fre == 0)
            fre = 1;
        return resBuilder.toString().repeat(fre);
    }
}

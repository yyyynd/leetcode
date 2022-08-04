package leetcode.leetCode2022_08;

public class k306 {

    public static void main(String[] args) {
        System.out.println(new k306().isAdditiveNumber("0235813"));
    }

    int len;
    char[] n;
    public boolean isAdditiveNumber(String num) {
        n = num.toCharArray();
        len = num.length();

        if (n[0] == '0') {
            long num2 = 0;


            if (n[1] == '0'){
                if (dfs(0, 0, 2))
                    return true;
            }else{
                for (int j = 1; j < len - 1; j++) {
                    num2 = num2 * 10 + n[j] - '0';
                    if (dfs(0, num2, j + 1))
                        return true;
                }
            }//else
        }

        long num1 = 0;
        for (int i = 0; i < len - 2; i++){
            num1 = num1 * 10 + n[i] - '0';
            if (i > len / 2)
                return false;
            long num2 = 0;
            if (n[i+1] == '0'){
                if (dfs(num1, 0, i+2))
                    return true;
            }else{
                for (int j = i + 1; j < len - 1; j++) {
                    num2 = num2 * 10 + n[j] - '0';
                    if (dfs(num1, num2, j + 1))
                        return true;
                }
            }//else
        }//for
        return false;
    }

    public boolean dfs(long num1, long num2,int index){
        if(index == len)
            return true;

        char[] cur = String.valueOf(num1 + num2).toCharArray();
        if (cur.length > len - index)
            return false;

        for (int i = index, j = 0; i < len && j < cur.length; i++, j++){
            if (cur[j] != n[i])
                return false;
        }

        return dfs(num2, num1 + num2, index + cur.length);
    }
}

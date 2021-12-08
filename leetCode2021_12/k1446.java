package leetCode2021_12;

public class k1446 {

    public int maxPower(String s) {
        char[] str = s.toCharArray();
        int ans = 1;
        int tmp = 1;
        char pre = str[0];
        for (int i = 1; i < str.length; i++){
            if(pre != str[i]){
                ans = Math.max(ans, tmp);
                tmp = 1;
            }else
                tmp++;
            pre = str[i];
        }

        ans = Math.max(ans, tmp);
        return ans;
    }
}

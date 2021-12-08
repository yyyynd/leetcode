package leetCode2021_12;

public class k1816 {
    public String truncateSentence(String s, int k) {
        boolean flag = false;
        int right = 0;
        int count = 0;
        char[] str = s.toCharArray();
        while (right < s.length() && count < k){
            if(str[right] != ' ' && !flag){
                flag = true;
            }else if(str[right] == ' ' && flag){
                count++;
                flag = false;
            }

            right++;
        }

        return s.substring(0, right == s.length() ? right : right - 1);

    }
}

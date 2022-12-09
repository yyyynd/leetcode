package leetcode.leetCode2022_12;

public class k1769 {
    public static void main(String[] args) {
        new k1769().minOperations("110");
    }
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] ans = new int[len];
        int[] sum_s = new int[len + 2];
        int[] sum_r = new int[len + 2];
        for (int i = 0; i < len; i++){
            if (boxes.charAt(i) == '1'){
                sum_s[i + 1] = sum_s[i] + 1;
            }else
                sum_s[i + 1] = sum_s[i];
        }

        for (int i = len - 1; i >= 0; i--){
            if (boxes.charAt(i) == '1'){
                sum_r[i + 1] = sum_r[i + 2] + 1;
            }else
                sum_r[i + 1] = sum_r[i + 2];
        }
        //跳过头开始记录从左往右
        for (int i = 1 ; i < len; i++){
            ans[i] += ans[i - 1] + sum_s[i];
        }

        int[] tmp = new int[len];
        //跳过尾开始记录从右往左
        for (int i = len - 2; i >= 0; i--){
            tmp[i] += tmp[i + 1] + sum_r[i + 2];
        }

        for (int i = 0; i < len; i++)
            ans[i] += tmp[i];

        return ans;
    }
}

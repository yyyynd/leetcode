package leetcode.leetCode2022_02;

/**
 * 利用两个数相乘最多得两位数的规律，且必定产生的是i+j,i+j+1两个位置的数
 * 只需每次计算出一个两位数即可，减少计算量
 */
public class k43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int num1_len = num1.length();
        int num2_len = num2.length();
        int[] tmp = new int[num2_len + num1_len];
        StringBuilder res = new StringBuilder();

        for (int i = num1_len - 1; i >= 0; i--) {
            int n = num1.charAt(i) - '0';
            for (int j = num2_len - 1; j >= 0; j--) {
                //这里顺便做到了进位计算
                int curRes = tmp[i + j + 1] + (num2.charAt(j) - '0') * n;
                tmp[i + j + 1] = curRes % 10;
                tmp[i + j] += curRes / 10;
            }
        }

        for (int i = tmp[0] == 0 ? 1 : 0; i < tmp.length; i++)
            res.append(tmp[i]);

        return res.toString();
    }
}

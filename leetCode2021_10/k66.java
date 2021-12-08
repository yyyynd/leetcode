package leetCode2021_10;

import java.util.Arrays;

/**
 * 考虑进位问题
 */
public class k66 {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;//标记最终停止进位的位置
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }

        if(index == -1){
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }else {
            digits[index]++;
            return digits;
        }
    }
}

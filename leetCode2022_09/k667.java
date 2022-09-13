package leetcode.leetCode2022_09;

import java.util.Arrays;

public class k667 {
    public static void main(String[] args) {
        new k667().constructArray(5, 4);
    }
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        if(k == 1){
            for (int i = 0; i < n; i++)
                ans[i] = i + 1;
            return ans;
        }
        int left = 2;
        int right = n;
        int index = 1;
        ans[0] = 1;
        while (k >= 2){
            ans[index++] = right--;
            ans[index++] = left++;
            k -= 2;
        }
        //如果后续还有余数的话，则需要考虑自增1带来的额外结果
        if (left <= right) {
            //如果还需要一个结果则正常完成数组就行
            if (k == 1) {
                while (index < n)
                    ans[index++] = left++;
            }else{
                //最后一次加入的left数字删除，从right开始重新填入
                index--;
                while (index < n)
                    ans[index++] = right--;
            }
        }
        return ans;
    }
}

package leetcode.leetCode2022_10;

public class k978 {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int flag = 0;
        int tmp = 1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - arr[i - 1] > 0){
                tmp = flag <= 0 ? tmp + 1 : 2;
                flag = 1;
            }else if (arr[i] - arr[i - 1] < 0){
                tmp = flag >= 0 ? tmp + 1 : 2;
                flag = -1;
            }else {
                flag = 0;
                tmp = 1;
            }
            ans = Math.max(tmp, ans);
        }
        return ans;
    }
}

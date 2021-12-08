package leetCode2021_05_09;

public class k1646 {
    public int getMaximumGenerated(int n) {
        if(n == 0)
            return 0;
        int[] ar = new int[n+1];
        ar[0] = 0;
        ar[1] = 1;
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0){
                ar[i] = ar[i/2];
                ans = Math.max(ans, ar[i]);
            }else {
                ar[i] = ar[i/2] + ar[i/2 + 1];
                ans = Math.max(ans,ar[i]);
            }
        }//for

        return ans;
    }
}

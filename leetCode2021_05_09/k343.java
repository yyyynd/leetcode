package leetCode2021_05_09;

public class k343 {
    int[] dp;

    public static void main(String[] args) {
        System.out.println(new k343().integerBreak(10));
        System.out.println("pause");
    }

    public int integerBreak(int n) {
        this.dp = new int[n];
        return fun(n);
    }

    public int fun(int num){
        int max = 1;

        if(dp[num-1] != 0)
            return dp[num-1];

        for(int i = 1; i < num; i++){
            if(dp[num-i-1] != 0)
                max = Math.max(max,i*(dp[num-i-1]));
            else
                max = Math.max(max,i*fun(num-i));
        }

        //这里主要是针对的n-1前的结果，不影响最后求n的拆分
        dp[num-1] = Math.max(max,num);
        return max;
    }
}

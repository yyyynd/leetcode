package leetcode.leetCode2022_02;

public class k1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        int ans = 0;
        while ( b < k ){
            int c = a + b;
            a = b;
            b = c;
        }

        while ( k > 0 ){
            if( b <= k ){
                ans++;
                k = k - b;
            }
            int c = b - a;
            b = a;
            a = c;
        }

        return ans;
    }
}

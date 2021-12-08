package leetCode2021_09;

public class k517 {

    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int i : machines)
            sum += i;
        if (sum % n != 0)
            return -1;
        int t = sum / n;
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= machines[i];
            //a,b为左右差值
            int a = Math.max(t * i - ls, 0);
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(ans, a + b);
            ls += machines[i];
        }
        return ans;
    }
}

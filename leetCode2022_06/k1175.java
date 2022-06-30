package leetcode.leetCode2022_06;

public class k1175 {
    public static void main(String[] args) {
        System.out.println(new k1175().numPrimeArrangements(100));
    }
    public int numPrimeArrangements(int n) {
        int mod = (int) (1e9 + 7);
        long ans = 1;
        int count = 0; // 质数数量统计
        for (int i = 2; i <= n; i++){
            if (check(i))
                count++;
        }

        for (int i = 2; i <= n - count; i++)
            ans = (ans *  i) % mod;

        for (int i = 2; i <= count; i++)
            ans = (ans * i) % mod ;

        return (int)ans;
    }

    public boolean check(int target){
        for (int i = 2; i <= (int)Math.sqrt(target); i++)
            if (target % i == 0)
                return false;
        return true;
    }
}

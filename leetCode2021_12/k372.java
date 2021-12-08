package leetCode2021_12;


/**
 * 关键点就是将计算拆分成小块分别进行计算然后最终得出结果
 * 利用了模运算和幂运算的性质实现: (a * b) % c = ((a % c) * (b % c)) % c
 * pow(a,y),在y = b+c+d时, pow(a, b+c+d) = pow(a,b) * pow(a,c) * pow(a,d)
 * 而bcd一般采用二进制进行拆分，每次循环利用 a = a*a得出在该位的 a结果
 */
public class k372 {
    public static void main(String[] args) {
        System.out.println(9 *6 %4);
        System.out.println(((9%4)*(6%4))%4);
    }


    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    public int dfs(int a, int[]b, int length){
        if( length == -1)
            return 1;
        return modPow( dfs(a, b, length - 1), 10) * modPow(a, b[length]) % MOD;
    }

    public int modPow(int a, int b){
        int ans = 1;
        a %= a;
        while (b != 0){
            if( (b & 1) == 1)
                ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }

        return ans;
    }
//    int dfs(int a, int[] b, int u) {
//        if (u == -1) return 1;
//        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
//    }
//    int qpow(int a, int b) {
//        int ans = 1;
//        a %= MOD;
//        while (b != 0) {
//            if ((b & 1) != 0)
//                ans = ans * a % MOD;
//            a = a * a % MOD;
//            b >>= 1;
//        }
//        return ans;
//    }

}

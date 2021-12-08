package leetCode2021_05_09;

public class k1137 {
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;

        int f1 = 0;
        int f2 = 1;
        int f3 = 1;

        for (int i = 3; i <= n; i++){
            int tmp = f1+f2+f3;
            f1 = f2;
            f2 = f3;
            f3 = tmp;
        }

        return f3;
    }
}

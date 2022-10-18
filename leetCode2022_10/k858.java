package leetcode.leetCode2022_10;

public class k858 {
    public static void main(String[] args) {
        System.out.println(new k858().mirrorReflection(3,2));
    }
    public int mirrorReflection(int p, int q) {
        if (q == 0)
            return 0;
        int m = p;
        while (m % q != 0)
            m += p;

        if ((m / q) % 2 == 0)
            return 2;
        else {
            return (m / p) % 2 == 0 ? 0 : 1;
        }
    }
}

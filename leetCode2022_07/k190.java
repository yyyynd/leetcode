package leetcode.leetCode2022_07;

public class k190 {
    public static void main(String[] args) {
        System.out.println(new k190().reverseBits(-3));
    }
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}

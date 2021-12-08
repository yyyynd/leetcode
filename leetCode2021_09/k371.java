package leetCode2021_09;

public class k371 {
    public static void main(String[] args) {
        System.out.println(new k371().getSum(-6,Integer.MAX_VALUE));
        System.out.println((-6 >> 2)& 1);
    }
    public int getSum(int a, int b) {
        int ans = 0;
        for (int i = 0, t = 0; i < 32; i++) {
            int u1 = (a >> i) & 1, u2 = (b >> i) & 1;
            if (u1 == 1 && u2 == 1) {
                ans |= (t << i);
                t = 1;
            } else if (u1 == 1 || u2 == 1) {
                ans |= ((1 ^ t) << i);
            } else {
                ans |= (t << i);
                t = 0;
            }
        }
        return ans;
    }

}

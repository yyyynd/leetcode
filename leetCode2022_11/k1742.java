package leetcode.leetCode2022_11;

public class k1742 {
    public static void main(String[] args) {
        System.out.println(new k1742().countBalls(5,15));
    }
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnts = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = i, cur = 0;
            while (j != 0) {
                cur += j % 10; j /= 10;
            }
            if (++cnts[cur] > ans) ans = cnts[cur];
        }
        return ans;
    }
}

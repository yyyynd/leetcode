package leetcode.lccup2022;

public class n1 {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < temperatureA.length - 1; i++){
            int a = temperatureA[i] - temperatureA[i + 1];
            int b = temperatureB[i] - temperatureB[i + 1];
            if ((a < 0 && b < 0) || (a == 0 && b == 0) || (a > 0 && b > 0))
                cur++;
            else {
                ans = Math.max(ans, cur);
                cur = 0;
            }
        }
        ans = Math.max(ans, cur);
        return ans;
    }
}

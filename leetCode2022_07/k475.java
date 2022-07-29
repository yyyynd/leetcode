package leetcode.leetCode2022_07;

import java.util.Arrays;

public class k475 {
    public static void main(String[] args) {
        int[] a = new int[15226];
        for (int i = 1; i <= 15225; i++)
            a[i-1] = i;
        a[15225] = 1522;
        System.out.println(new k475().findRadius(a, a));
    }
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        int i = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house : houses){
            int tmp = Integer.MAX_VALUE;
            for (int j = i; j < heaters.length; j++) {
                int cur = Math.abs(house - heaters[j]);
                if (cur <= tmp){
                    tmp = cur;
                    i = j;
                }else
                    break;
            }
            if (tmp != 0)
                System.out.println(heaters[i]+"+"+house);

            ans = Math.max(ans , tmp);
        }

        return ans;
    }
}

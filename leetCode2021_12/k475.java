package leetCode2021_12;

import java.util.Arrays;

/**
 * 考虑每个房屋离的最近的加热器距离，然后这些距离中的最大值就是最终结果
 * 这里的房屋离得最近的加热器距离需要考虑其左右两个加热器
 */
public class k475 {
    public static void main(String[] args) {
        System.out.println(new k475().findRadius(new int[]{474833169,264817709,998097157,817129560},
                new int[]{197493099,404280278,893351816,505795335}));
    }
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        int rightHeater = 1;//右侧加热器下标
        int i = 0;

        Arrays.sort(heaters);
        Arrays.sort(houses);
        while (i < houses.length && houses[i] <= heaters[0])
            i++;
        ans = heaters[0] - houses[0];

        for (; rightHeater < heaters.length; rightHeater++){
            while (i < houses.length && heaters[rightHeater] >= houses[i]){
                ans = Math.max(ans,
                        Math.min(heaters[rightHeater] - houses[i], houses[i] - heaters[rightHeater - 1]));
                i++;
            }
        }
        ans = Math.max(ans, houses[houses.length - 1] - heaters[heaters.length - 1]);

        return ans;
    }
}

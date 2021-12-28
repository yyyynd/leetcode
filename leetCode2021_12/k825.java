package leetCode2021_12;

import java.util.Arrays;
import java.util.SortedSet;

/**
 * 条件2 y > x 意味着y <= x才行这就是一个右边界
 * 条件1 y <= x * 0.5 + 7 意味着y比x再小也不能小于该值，即左边界
 * 条件3 y > 100 && x < 100 如果上述范围出现大于等于100的部分，需要x本身值大于100
 *
 * age <= 14不会加好友
 *
 * 然后前缀和主要如果你要得[left,right]范围的值，应该用sum[right] - sum[left-1]
 */
public class k825 {
    public static void main(String[] args) {
        System.out.println(new k825().numFriendRequests(new int[]{16,17,18}));
    }
    public int numFriendRequests(int[] ages) {
        int ans = 0;
        int[] count = new int[121];
        int[] sum = new int[121];
        for(int n : ages)
            count[n]++;
        for (int i = 1; i <= 120; i++)
            sum[i] += sum[i - 1] + count[i];

        for (int i = 15; i <= 120; i++){
            if(count[i] == 0)
                continue;
            int left = (int) (i * 0.5 + 7);//条件1 y <= x * 0.5 + 7
            int right = i - 1;//条件2 y > x
            ans += (sum[right] - sum[left]) * count[i];
            ans += count[i] * (count[i] - 1);
        }//for
        return ans;
    }

}

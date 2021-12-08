package leetCode2021_11;

import java.util.HashSet;

public class k575 {
    public int distributeCandies(int[] candyType) {
        int maxLimit = candyType.length / 2;
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int k : candyType){
            if(ans == maxLimit)
                break;

            if(set.add(k))
                ans++;
        }

        return ans;
    }
}

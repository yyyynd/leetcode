package leetCode2021_11;

public class k495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration;
        int curEneTime = timeSeries[0] + duration;
        for(int i = 1; i < timeSeries.length; i++){
            if(timeSeries[i] <= curEneTime)
                ans -= curEneTime - timeSeries[i];
            curEneTime = timeSeries[i] + duration;
            ans += duration;
        }

        return ans;
    }
}

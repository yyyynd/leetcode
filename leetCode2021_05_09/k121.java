package leetCode2021_05_09;

public class k121 {
    public int maxProfit(int[] prices) {
        int minPrices = prices[0];
        int maxProfits = 0;

        for(int i = 1; i < prices.length; i++){
            minPrices = Math.min(minPrices,prices[i]);
            maxProfits = Math.max(maxProfits,prices[i]-minPrices);
        }

        return maxProfits;
    }
}

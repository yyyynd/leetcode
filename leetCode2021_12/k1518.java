package leetCode2021_12;

public class k1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        while (numBottles >= numExchange){
            ans += numBottles - numBottles % numExchange;
            numBottles = numBottles % numExchange + numBottles / numExchange;
        }

        ans += numBottles;
        return ans;
    }
}

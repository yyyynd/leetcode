package leetCode2021_10;

/**
 * 注意这题提供的数据是有负数的
 * 然后主要就是异或计算的性质了 a^b^a = b
 */
public class k260 {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xorSum = 0;
        int k = -1;
        for(int n : nums)
            xorSum ^=  n;

        for (int i = 0; i < nums.length && k == -1; i++)
            if((xorSum >> i & 1) == 1)
                k = i;

        for (int n : nums){
            if((n >> k & 1) == 1)
                ans[0] ^= n;
            else
                ans[1] ^= n;
        }

        return ans;
    }
}

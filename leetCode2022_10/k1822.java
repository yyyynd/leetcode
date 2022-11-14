package leetcode.leetCode2022_10;

public class k1822 {
    public int arraySign(int[] nums) {
        int count = 0;
        for (int n : nums){
            if (n == 0)
                return 0;
            else if (n < 0)
                count++;
        }
        return count % 2 == 0 ?  1 : -1;
    }
}

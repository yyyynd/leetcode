package leetcode.leetCode2022_08;

public class k334 {

    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int n : nums){
            if (n <= n1)
                n1 = n;
            else if (n <= n2)
                n2 = n;
            else
                return true;
        }


        return false;
    }
}

package leetCode2021_05_09;

import java.util.HashSet;

public class k532 {

    public static void main(String[] args) {
        int[] arr = {23,2,4,6,6};

        if (new k532().checkSubarraySum(arr,7))
            System.out.println("success");
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int row = nums.length;
        long[] sum = new long[row+1];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 1; i<=row; i++)
            sum[i] = nums[i-1] + sum[i-1];

        for(int i = 2; i <= row; i++){
            set.add((int)(sum[i-2]%k));
            if(set.contains((int)(sum[i]%k)))
                return true;
        }

        return false;
    }
}

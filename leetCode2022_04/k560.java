package leetcode.leetCode2022_04;

import java.util.HashMap;

public class k560 {
    public static void main(String[] args) {
        System.out.println(new k560().subarraySum(new int[]{1,2,3}, 3));
    }
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] psum = new int[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= nums.length; i++){
            psum[i] = psum[i-1] + nums[i-1];
            if (map.containsKey(psum[i] - k))
                ans += map.get(psum[i] - k);
            map.put(psum[i], map.getOrDefault(psum[i], 0) + 1);
        }

//        for(int i = 0; i < nums.length; i++){
//            int l = psum[i];
//            for (int j = i + 1; j < nums.length + 1; j++){
//                if ( psum[j] - l == k)
//                    ans++;
//            }
//        }

        return ans;
    }
}
